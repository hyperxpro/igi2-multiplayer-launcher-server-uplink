package aayush.atharva.igi2.multiplayer.launcher.server.uplink;

/**
 *
 * @author Hyper
 */
public class Restarter extends Thread {

    private String RCON;
    private String PORT;

    public Restarter(String RCON, String PORT) {
        this.RCON = RCON;
        this.PORT = PORT;
    }

    @Override
    public void run() {

        while (true) {

            if (Main.LogAnalyzeReboot) {
                new LogAnalyze(getRCON(), getPORT()).start();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

    public String getRCON() {
        return RCON;
    }

    public String getPORT() {
        return PORT;
    }

}
