package aayush.atharva.igi2.multiplayer.launcher.server.uplink;

import aayush.atharva.TurboCryptography.Decryption;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Hyper
 */
public class StartUpProcess {

    public static String Maintenance;
    public static String Message;
    public static String SupportOver;
    public static String LatestVersion;
    public static String DownloadLink;
    public static String SystemInfo;

    public void Process() {

        try {

            // Launcher Data Status
            StringBuilder sb = new StringBuilder();

            URLConnection connection = new URL("https://api-igi2.igi2.co.in/uplink/v1.6/Data.LAUNCHER").openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/58.0.1271.95 Safari/537.11");
            connection.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();

            String OriginalPassword = new Decryption(Main.AESSecretKey, Main.CBCA, Main.CBCB, Main.KeyAES, Main.Key, Main.IV, sb.toString()).Decrypt();

            Properties prop = new Properties();
            InputStream input = new ByteArrayInputStream(OriginalPassword.getBytes(StandardCharsets.UTF_8.name()));
            prop.load(input);

            Maintenance = prop.getProperty("Maintenance");
            Message = prop.getProperty("Message");
            SupportOver = prop.getProperty("SupportOver");
            LatestVersion = prop.getProperty("LatestVersion");
            DownloadLink = prop.getProperty("DownloadLink");

            // Maintenance
            if (!Maintenance.equals("None")) {
                JOptionPane.showMessageDialog(null, "IGI-2 Multiplayer Launcher Server Uplink Is Under Maintenance.\nPlease try again after " + Maintenance + ".\nThank You!", "Maintaince Break", 1);
                System.exit(0);
            }
            
            System.out.println(Maintenance);

            // Message
            if (!Message.equals("None")) {
                JOptionPane.showMessageDialog(null, Message, "Message!", JOptionPane.INFORMATION_MESSAGE);
            }

            // Update Check
            {
                if (!LatestVersion.equals("1.6")) {
                    int choice = -2;

                    String[] options = {"Yes", "No", "Cancel"};
                    choice = JOptionPane.showOptionDialog(null, "IGI-2 Multiplayer Launcher Server Uplink v" + LatestVersion + " Is Available To Be Downloaded!\nWould You Like To Download?", "Updates Are Available", 0,
                            JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    switch (choice) {
                        case 0:
                            Desktop.getDesktop().browse(new URL(DownloadLink).toURI());
                            break;
                        case 1:

                            break;
                        default:
                            choice = -1;
                            break;
                    }
                }
            }

            // Support Over Check
            if (SupportOver.equals("Yes")) {
                javax.swing.JOptionPane.showMessageDialog(null, "IGI-2 Multiplayer Launcher Server Uplink v1.6 Support Is Over!\nPlease Update To IGI-2 Multiplayer Launcher Server Uplink v" + LatestVersion, "IGI-2 Multiplayer Launcher Server Uplink v1.6 Support Over!", 1);

                int choice = -2;

                String[] options = {"Yes", "No", "Cancel"};
                choice = JOptionPane.showOptionDialog(null, "IGI-2 Multiplayer Launcher Server Uplink v" + LatestVersion + " Is Available To Be Downloaded!\nWould You Like To Download?", "Updates Are Available", 0,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                switch (choice) {
                    case 0:
                        Desktop.getDesktop().browse(new URL(DownloadLink).toURI());
                        break;
                    case 1:

                        break;
                    default:
                        choice = -1;
                        break;
                }

                System.exit(0);
            }

            new SignIn_GUI();

        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Start IGI-2 Multiplayer Launcher Server Uplink. Please Reinstall IGI-2 Multiplayer Server Essentials.\n Contact Support at: \"aayush@igi2.co.in\" for further help.", "Error 132", JOptionPane.ERROR_MESSAGE);
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Open Browser For Downloading New Updates.\n Contact Support at: \"aayush@igi2.co.in\" for further help.", "Fatal Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IGI-2 Multiplayer Launcher Server Uplink End-Point Error While Fetching Data At Startup Checks\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Checksum Failure", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
        }

    }
}
