package aayush.atharva.igi2.multiplayer.launcher.server.uplink;

import static aayush.atharva.igi2.multiplayer.launcher.server.uplink.Main.RegisterQuery;

/**
 *
 * @author Hyper
 */
public class ServerInfoBeacon extends Thread {

    private String Port;
    private String RCON;
    private String AuthMethod;

    public ServerInfoBeacon(String Port, String RCON, String AuthMethod) {
        this.Port = Port;
        this.RCON = RCON;
        this.AuthMethod = AuthMethod;
    }

    @Override
    public void run() {

        while (true) {

            if (!Main.isServiceStarted) {
                return;
            }

            new ServerConnector(RegisterQuery + "\n" + "PORT=" + getPort() + "\n" + "RCON=" + getRCON() + "\n" + "Password_Method=[" + getAuthMethod() + "]").Server();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
        }
    }

    public String getPort() {
        return Port;
    }

    public String getRCON() {
        return RCON;
    }

    public String getAuthMethod() {
        return AuthMethod;
    }

}
