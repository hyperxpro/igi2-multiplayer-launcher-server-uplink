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
