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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.swing.JOptionPane;

public class Sign_In {

    public static String MP_Name;

    private String Username_Email;
    private String Password;

    public Sign_In(String Username_Email, String Password) {
        this.Username_Email = Username_Email;
        this.Password = Password;
    }

    public void SignIn() throws Exception {

        String Email_Username = getUsername_Email();
        String UserPassword = getPassword();

        if (Email_Username.contains("@")) { // Email

            String SignerID = generateSignInID();
            String SignInData = "Query=SignIn" + "\n"
                    + "AuthHeader=Email" + "\n"
                    + "Email=" + Email_Username + "\n"
                    + "Password=" + UserPassword + "\n"
                    + "SignerID=" + SignerID + "\n"
                    + "MachineGUID=" + "" + "\n" 
                    + "MoboUUID=" + "" + "\n"
                    + "HDD_SN=" + "";

            String Response = new ServerConnector(SignInData).Server();

            Properties Data = new Properties();
            InputStream input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
            Data.load(input);

            if (Data.getProperty("Response").equals("No Account Exist With The Email Address You Entered")) {
                JOptionPane.showMessageDialog(null, "No Account Exists With The Email Which You've Entered.\nPlease Enter A Valid Email", "Wrong Email", JOptionPane.ERROR_MESSAGE);
            } else if (Data.getProperty("Response").equals("Session Authenticated") && Data.getProperty("SignerID").equals(SignerID)) {
                Main.UserIdentity = "";

                Main.Authentication_Check = "Yes Autheneitcated, Authentication Completed...";
            } else if (Data.getProperty("Response").equals("Wrong Password")) {
                JOptionPane.showMessageDialog(null, "Please Enter Correct Password.", "Incorrect Password", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, Data.getProperty("Response"), "Message", JOptionPane.INFORMATION_MESSAGE);
            }

        } else { // Username
            String SignerID = generateSignInID();
            String SignInData = "Query=SignIn" + "\n"
                    + "AuthHeader=Username" + "\n"
                    + "Username=" + Email_Username + "\n"
                    + "Password=" + UserPassword + "\n"
                    + "SignerID=" + SignerID + "\n"
                    + "MachineGUID=" + "" + "\n" 
                    + "MoboUUID=" + "" + "\n"
                    + "HDD_SN=" + "";

            String Reponse = new ServerConnector(SignInData).Server();

            Properties Data = new Properties();
            InputStream input = new ByteArrayInputStream(Reponse.getBytes(StandardCharsets.UTF_8.name()));
            Data.load(input);

            if (Data.getProperty("Response").equals("No Account Exist With The Username You Entered")) {
                JOptionPane.showMessageDialog(null, "No Account Exists With The Username Which You've Entered.\nPlease Enter A Valid Username", "Wrong Username", JOptionPane.ERROR_MESSAGE);
            } else if (Data.getProperty("Response").equals("Session Authenticated") && Data.getProperty("SignerID").equals(SignerID)) {
                Main.Authentication_Check = "Yes Autheneitcated, Authentication Completed...";
            } else if (Data.getProperty("Response").equals("Wrong Password")) {
                JOptionPane.showMessageDialog(null, "Please Enter Correct Password.", "Incorrect Password", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, Data.getProperty("Response"), "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public String getUsername_Email() {
        return Username_Email;
    }

    public String getPassword() {
        return Password;
    }

    public String DateTimeLocal() {
        SimpleDateFormat sdf = new SimpleDateFormat("[HH:mm:ss dd-MMM-yyyy]");
        return sdf.format(new Date());
    }

    public String generateSignInID() {
        return generateRandomChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 20);
    }

    // Generate Random Code
    public String generateRandomChars(String candidateChars, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i = i + 1) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        return sb.toString();
    }
}
