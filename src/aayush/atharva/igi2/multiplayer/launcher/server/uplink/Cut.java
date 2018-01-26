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
