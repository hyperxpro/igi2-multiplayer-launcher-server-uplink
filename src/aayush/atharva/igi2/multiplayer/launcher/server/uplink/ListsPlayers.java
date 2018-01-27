/*
 * IGI-2 Multiplayer Launcher Server Uplink
 *
 * Copyright (c) 2018, Aayush Atharva
 *
 * Permission is hereby granted, free of charge to any person obtaining a copy of this software and associated documentation files 
 * (the "Software"), to deal in the Software with restriction. A person can use, copy the Software without restriction. But if a person 
 * modify the software, the person must push the code to the Software GitHub repository. If a person wants to publish or distribute the 
 * software, the person must put this "Created By: Aayush Atharva" on About Section of the Software And this License must be present with 
 * every file of the Software. And If a person wants to sell the software, the person get permission from the owner of this Software.
 *
 *
 *
 *
 * IGI-2 Multiplayer Launcher Server Uplink
 * Owner: Aayush Atharva
 * Email: aayush@igi2.co.in
 */
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
