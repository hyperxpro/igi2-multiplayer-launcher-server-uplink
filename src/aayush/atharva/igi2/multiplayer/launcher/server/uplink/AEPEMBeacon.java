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
