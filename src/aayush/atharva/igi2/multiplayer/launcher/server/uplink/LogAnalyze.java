/*
IGI-2 Multiplayer Launcher Server Uplink

Copyright (c) 2018, Aayush Atharva

Permission is hereby granted, free of charge to any person obtaining a copy of this software and associated documentation files 
(the "Software"), to deal in the Software with restriction. A person can use, copy the Software without restriction. But if a person modify
the software, the person must push the code to the Software GitHub repository. If a person wants to publish or distribute the software,
the person must put this "Created By: Aayush Atharva" on About Section of the Software. And If a person want's to sell the software,
the person get permission from the owner of this Software. 


IGI-2 Multiplayer Launcher Server Uplink
Owner: Aayush Atharva
Email: aayush@igi2.co.in
*/

package aayush.atharva.igi2.multiplayer.launcher.server.uplink;

import static aayush.atharva.igi2.multiplayer.launcher.server.uplink.ListsPlayers.getPlayerById;
import static aayush.atharva.igi2.multiplayer.launcher.server.uplink.ListsPlayers.listPlayers;
import static aayush.atharva.igi2.multiplayer.launcher.server.uplink.ListsPlayers.poppedPlayers;
import static aayush.atharva.igi2.multiplayer.launcher.server.uplink.ListsPlayers.rmPlayer;
import static aayush.atharva.igi2.multiplayer.launcher.server.uplink.Main.PlayerQuery;
import static aayush.atharva.igi2.multiplayer.launcher.server.uplink.Main_GUI.setLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class LogAnalyze extends Thread {

    private String ServerRCON;
    private String ServerPORT;
    public static String ServerID;

    public LogAnalyze(String RCON, String PORT) {
        ServerRCON = RCON;
        ServerPORT = PORT;
    }

    @Override
    public void run() {
        ServerID = getServerID(); // Generate New Server ID
        new AEPEMBeacon(getServerRCON(), getServerPORT()).start(); // Start AEPEM Beacon Transmission
        Analyze(); // Start Log Analyze
    }

    private void Analyze() {
        String Line = "";
        long dl;
        long poz = 0;
        RandomAccessFile file = null;

        try {
            file = new RandomAccessFile("Multiplayer.log", "r");

            while (true) {

                dl = file.length();
                file.seek(poz);

                if (poz > dl) {
                    setLog("Server Restarted, Preparing To Restart Service...");
                    Main.LogAnalyzeReboot = true;
                    return;
                }

                if (Main.LogAnalyzeReboot) {
                    Main.LogAnalyzeReboot = false;
                }

                while (poz < dl) {

                    Line = file.readLine();
                    poz = file.getFilePointer();

                    if (!Main.isServiceStarted) {
                        return;
                    }

                    //new player in queue
                    if (Line.contains("Popped new networkID for joining client:")) {
                        String id, ip;
                        id = Cut.substr(Line, 53, "]");
                        ip = Cut.substr(Line, Line.indexOf("][") + 2, ":");
                        poppedPlayers.add(new Player(id, ip));
                    } //new player joined to server
                    else if (Line.contains("Client[") && Line.contains("created locally")) {
                        if (Line.indexOf("[]") > -1) {
                            continue;
                        }

                        String id = Cut.substr(Line, 18, "]");
                        String nick = Cut.substrEndOf(Line, Line.indexOf("][") + 2, "] cre");
                        for (Player player : poppedPlayers) {
                            if (player.getID().endsWith(id)) {
                                LogNewPlayer(player.getID(), player.getIP(), nick);
                                listPlayers.add(new Player(player.getID(), player.getIP(), nick));
                                poppedPlayers.remove(player);
                                checkBanner(nick, id);
                                break;
                            }
                        }
                    } else if (Line.indexOf("][") == 13 || Line.indexOf("][") == 14) {
                        //player left
                        if (Line.contains(" left the game")) {
                            String id = Cut.substr(Line, 12, "]");
                            String nick = Cut.substrEndOf(Line, Line.indexOf("][") + 2, "]");
                            rmPlayer(id);
                        } //lost connection
                        else if (Line.contains(" removed: Connection lost")) {
                            String id = Cut.substr(Line, 12, "]");
                            String nick = Cut.substrEndOf(Line, Line.indexOf("][") + 2, "]");
                            rmPlayer(id);
                        } //kicked
                        else if (Line.contains(" kicked out of the game")) {
                            String id = Cut.substr(Line, 12, "]");
                            String nick = Cut.substrEndOf(Line, Line.indexOf("][") + 2, "]");
                            rmPlayer(id);
                        }
                    } else if (Line.contains("Client_Deletehandler: Removing ")) {
                        String id = Cut.substr(Line, 43, "]");
                        if (getPlayerById(id) != null) {
                            String nick = Line.substring(43 + id.length() + 1);
                            rmPlayer(id);
                        }
                    }
                }

                Thread.sleep(100);

            }
        } catch (NullPointerException ex) {
        } catch (IOException | InterruptedException ex) {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException ex1) {
            }
        } catch (Exception ex) {
        }
    }

    private void LogNewPlayer(String ID, String IP, String MP_Name) throws IOException, InterruptedException, Exception {

        String Date = getDateTime();

        Thread.sleep(1000);

        String Response = new ServerConnector(PlayerQuery + "\n" + "PORT=" + getServerPORT() + "\n" + "MP_Name=" + MP_Name).Server();

        Properties Data = new Properties();
        InputStream input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
        Data.load(input);

        if (Data.getProperty("Response").equals("Not_Found")) {
            kick(ID);
            kick(ID);
            sendAnnounce("[" + ID + "] Was Kicked For Using Cheat Or Hack");
            setLog(Date, "New Player Joined [" + ID + "] [" + IP + "]" + " Player Name: " + MP_Name);
            setLog(Date, "AuthenticJoin Validation Failed, Player Might Be Using Cheat Or Hack. Removing Player...");
        } else {
            setLog(Date, "New Player Joined [" + ID + "] [" + Data.getProperty("IP") + "]" + " Player Name: " + MP_Name);
        }

    }

    private void checkBanner(String Nick, String ID) {

        Properties prop = new Properties();
        InputStream input = null;
        StringBuilder sb = new StringBuilder();

        File banned_file = new File("Banned_Players.txt");
        if (!banned_file.exists()) {
            try {
                banned_file.createNewFile();
            } catch (IOException ex) {
                setLog("Error While Creating Banned_Players.txt File");
            }
        }

        try {
            Scanner scanner = new Scanner(banned_file);
            while (scanner.hasNextLine()) {
                String Data;
                Data = scanner.nextLine().replaceAll("\\s", "\\\\u0020");
                sb.append(Data).append("\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            setLog("Banned_Players.txt File Not Found");
        }

        try {

            input = new ByteArrayInputStream(sb.toString().getBytes(StandardCharsets.UTF_8.name()));
            prop.load(input);

            String status = prop.getProperty(Nick);

            if (status != null) {
                kick(ID);
                setLog("[" + ID + "] " + Nick + " Was Kicked For Banned Player");
                if (Main.isAnnounceBanned) {
                    sendAnnounce("[" + ID + "] Was Banned And Has Been Kicked");
                }
            }

        } catch (IOException ex) {
        } catch (Exception ex) {
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private void kick(String ID) {
        try {
            sendCommand("kick " + ID);
            Thread.sleep(10);
            sendCommand("kick " + ID);
        } catch (Exception ex) {
        }
    }

    private void sendCommand(String command) throws Exception {
        String Command = "/sv " + command;
        String Rcon = "/" + getServerRCON();

        InetAddress servAddr = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
        byte[] buf = Rcon.getBytes();
        byte[] buf2 = Command.getBytes();
        DatagramSocket socket;
        socket = new DatagramSocket();
        socket.send(new DatagramPacket(buf, buf.length, servAddr, Integer.parseInt(getServerPORT())));
        Thread.sleep(10);
        socket.send(new DatagramPacket(buf2, buf2.length, servAddr, Integer.parseInt(getServerPORT())));
        socket.close();
    }

    private void sendAnnounce(String msg) throws Exception {
        String Command = "/lo announce (\"" + msg + "\")";
        String Rcon = "/" + getServerRCON();

        InetAddress servAddr = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
        byte[] buf = Rcon.getBytes();
        byte[] buf2 = Command.getBytes();
        DatagramSocket socket;
        socket = new DatagramSocket();
        socket.send(new DatagramPacket(buf, buf.length, servAddr, Integer.parseInt(getServerPORT())));
        Thread.sleep(10);
        socket.send(new DatagramPacket(buf2, buf2.length, servAddr, Integer.parseInt(getServerPORT())));
        socket.close();
    }

    private String getServerID() {
        return generateRandomChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 6);
    }

    private String generateRandomChars(String candidateChars, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i = i + 1) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        return sb.toString();
    }

    private String getServerRCON() {
        return ServerRCON;
    }

    private String getServerPORT() {
        return ServerPORT;
    }

    private String getDateTime() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a zzz");
        return "[" + ft.format(dNow) + "] ";
    }
}
