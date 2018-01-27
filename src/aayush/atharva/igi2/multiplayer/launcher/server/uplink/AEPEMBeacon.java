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

import static aayush.atharva.igi2.multiplayer.launcher.server.uplink.Main_GUI.setLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Random;

/**
 *
 * @author Hyper
 */
public class AEPEMBeacon extends Thread {

    private String RCON;
    private String PORT;

    public AEPEMBeacon(String RCON, String PORT) {
        this.RCON = RCON;
        this.PORT = PORT;
    }

    @Override
    public void run() {
        while (true) {

            if (Main.LogAnalyzeReboot) {
                return;
            }

            if (!Main.isServiceStarted) {
                return;
            }

            try {

                String Password = getNewAEPEMPassword();

                String Response = new ServerConnector(Main.ServerQuery + "\n" + "ID=" + LogAnalyze.ServerID + "\n" + "PORT=" + getPORT() + "\n" + "PASS=" + Password).Server();

                Properties Data = new Properties();
                InputStream input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
                Data.load(input);

                if (Data.getProperty("Response").equals("Change")) {
                    sendPassword(Password);
                    setLog("Setting New Authentication ID [AEPEM v2 + AuthenticJoin]");
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                }

            } catch (IOException ex) {

            }
        }
    }

    private void sendPassword(String pass) {
        String Packet = "/lo svpassword(\"" + pass + "\");";

        try {
            String rcon = "/" + getRCON();
            InetAddress servAddr = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
            byte[] buf = Packet.getBytes();
            DatagramSocket socket = new DatagramSocket();
            socket.send(new DatagramPacket(rcon.getBytes(), rcon.length(), servAddr, Integer.parseInt(getPORT())));
            Thread.sleep(15);
            socket.send(new DatagramPacket(buf, buf.length, servAddr, Integer.parseInt(getPORT())));
            socket.close();
        } catch (Exception ex) {
        }
    }

    private String getNewAEPEMPassword() {
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

    private String getRCON() {
        return RCON;
    }

    private String getPORT() {
        return PORT;
    }

}
