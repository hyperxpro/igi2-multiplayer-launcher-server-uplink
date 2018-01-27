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
