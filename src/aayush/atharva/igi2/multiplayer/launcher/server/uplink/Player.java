package aayush.atharva.igi2.multiplayer.launcher.server.uplink;

/**
 *
 * @author Mario PL
 */
public class Player {

    private String nick;
    private String id;
    private String ip;

    public Player(String id, String ip, String nick) {
        this.nick = nick;
        this.id = id;
        this.ip = ip;
    }

    public Player(String id, String ip) {
        this.id = id;
        this.ip = ip;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIP() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNick() {
        return nick;
    }

    public String getID() {
        return id;
    }

}
