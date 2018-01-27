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
 * @author Aayush Atharva
 */
public class Cut {

    static String substr(String txt, int start) {
        return txt.substring(start);
    }

    static String substr(String txt, int start, int end) {
        return txt.substring(start, end);
    }

    static String substr(String txt, int start, String end) {
        if (txt.indexOf(end, start + 1) < 0) {
            System.out.println(txt);
        }
        return txt.substring(start, txt.indexOf(end, start + 1));
    }

    static String substr(String txt, String start) {
        return txt.substring(txt.indexOf(start));
    }

    static String substr(String txt, String start, String end) {
        return txt.substring(txt.indexOf(start), txt.indexOf(end, txt.indexOf(start) + 1));
    }

    static String substr(String txt, String start, int end) {
        return txt.substring(txt.indexOf(start), end);
    }

    static String substrEndOf(String txt, String start, int end) {
        return txt.substring(txt.lastIndexOf(start), end);
    }

    static String substrEndOf(String txt, int start, String end) {
        return txt.substring(start, txt.lastIndexOf(end));
    }

    static String substrEndOf(String txt, String start) {
        return txt.substring(txt.lastIndexOf(start));
    }

    static String substrEndOf(String txt, String start, String end) {
        return txt.substring(txt.lastIndexOf(start), txt.lastIndexOf(end, txt.lastIndexOf(start) + 1));
    }

    static int count(String linia, char z) {
        int licz = 0;
        linia = linia.trim();
        char[] lin = linia.toCharArray();
        for (char zm : lin) {
            if (zm == z) {
                licz++;
            }
        }
        return licz;
    }

}
