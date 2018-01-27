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

/**
 *
 * @author Hyper
 */
public class Main {

    public static final String MASTERSERVERURL = "core-system-igi2-masterserver.igi2.co.in";
    public static final int MASTERSERVERPORT = 50000;

    public static String Authentication_Check = "Not Autheneitcated, Waiting For Authentication...";

    public static boolean isButtonPressed = true;
    public static boolean isServiceStarted = false;
    public static boolean LogAnalyzeReboot = false;
    public static boolean isServerRegistered = false;

    public static String UserIdentity;

    public static String ServerQuery = "Query=AEPEM_AuthenticJoin_Password";
    public static String RegisterQuery = "Query=Register_Server";
    public static String PlayerQuery = "Query=GPLRIP";
//    
    public static boolean isAnnounceAutoKick = false;
    public static boolean isAnnounceBanned = false;

//    public static String ServerQuery = "Query=AEPEM_AuthenticJoin_Password" + "\n" + "ServerIP=13.126.28.203";
//    public static String RegisterQuery = "Query=Register_Server" + "\n" + "ServerIP=13.126.28.203";
//    public static String PlayerQuery = "Query=GPLRIP" + "\n" + "ServerIP=13.126.28.203";
    public static void main(String[] args) {

        new StartUpProcess().Process();

        while (Authentication_Check.equals("Not Autheneitcated, Waiting For Authentication...")) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
        }

        Authentication_Check = "Not Autheneitcated, Waiting For Authentication..."; // Disable Authentication

        new Main_GUI();
    }

    public static final String AESSecretKey = ""; // AES KEY
    public static final String CBCA = ""; // 16 Bit
    public static final String CBCB = ""; // 16 Bit
    public static final String KeyAES = ""; // 128 Bit
    public static final String Key = ""; // 16 Bit Key
    public static final String IV = ""; // 16 Bit IV
}
