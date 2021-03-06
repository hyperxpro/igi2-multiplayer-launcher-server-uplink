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
