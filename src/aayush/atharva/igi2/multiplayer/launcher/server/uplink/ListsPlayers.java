package aayush.atharva.igi2.multiplayer.launcher.server.uplink;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aayush Atharva
 */
public class ListsPlayers {

    public static List<Player> listPlayers = new ArrayList<>();
    public static List<Player> poppedPlayers = new ArrayList<>();

    public static Player getPlayerById(String id) {
        for (Player p : listPlayers) {
            if (p.getID().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public static void rmPlayer(String id) {
        Player rm = null;
        for (Player p : listPlayers) {
            if (p.getID().equals(id)) {
                rm = p;
                break;
            }
        }
        if (rm != null) {
            listPlayers.remove(rm);
        }
    }

    public static void addPlayerToDatabase(Player player) {
        listPlayers.add(player);
    }

    public static Player getPlayerByNick(String nick) {
        for (Player p : listPlayers) {
            if (p.getNick().equals(nick)) {
                return p;
            }
        }
        return null;
    }

}
