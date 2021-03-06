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

/**
 *
 * @author Aayush Atharva
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
