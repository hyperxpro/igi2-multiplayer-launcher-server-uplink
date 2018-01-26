package aayush.atharva.igi2.multiplayer.launcher.server.uplink;

/**
 *
 * @author Hyper
 */
public class SendInformation extends Thread {

    private String ServerRCON;
    private String ServerPORT;
    private String AuthMethod;

    public SendInformation(String ServerRCON, String ServerPORT, String AuthMethod) {
        this.ServerRCON = ServerRCON;
        this.ServerPORT = ServerPORT;
        this.AuthMethod = AuthMethod;
    }

    @Override
    public void run() {

        if (getAuthMethod().contains("AEPEM")) {
            new LogAnalyze(getServerRCON(), getServerPORT()).start(); // Start Log Analyze Service
        }

        new Restarter(getServerRCON(), getServerPORT()).start(); // Start Restarter Service

        new ServerInfoBeacon(getServerPORT(), getServerRCON(), getAuthMethod()).start(); // Start Server Information Sender Service

    }

    public String getAuthMethod() {
        return AuthMethod;
    }

    public String getServerRCON() {
        return ServerRCON;
    }

    public String getServerPORT() {
        return ServerPORT;
    }
}
