package aayush.atharva.igi2.multiplayer.launcher.server.uplink;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Hyper
 */
public class Main_GUI extends javax.swing.JFrame {

    public Main_GUI() {
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        getRCON = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        getPort = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        auth_method = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        log_output = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        start_stop_button = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        announce_autokick = new javax.swing.JCheckBox();
        announce_banned = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IGI-2 Multiplayer Launcher Server Uplink");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("IGI-2 Multiplayer Launcher Server Uplink");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Server RCON: ");

        getRCON.setText("Enter Server RCON");
        getRCON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getRCONMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Server Port:");

        getPort.setText("Enter Server Port");
        getPort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getPortMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Authentication Method: ");

        auth_method.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AEPEM v2 + AuthenticJoin", "Manual Password" }));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        log_output.setEditable(false);
        log_output.setColumns(20);
        log_output.setRows(5);
        log_output.setWrapStyleWord(true);
        jScrollPane1.setViewportView(log_output);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Server Configuration");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Log");

        start_stop_button.setText("Start Server");
        start_stop_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_stop_buttonActionPerformed(evt);
            }
        });

        jLabel7.setText("v1.6");

        jButton1.setText("About");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Help For Authentication Method");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        announce_autokick.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        announce_autokick.setText("Announce Auto-Kick Message For Cheat / Hack Player");
        announce_autokick.setToolTipText("An Announce Message Will Be Made On Server When An Cheater / Hacker Is Kicked Out");

        announce_banned.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        announce_banned.setText("Announce Auto-Kick Message For Banned Player");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(jLabel1)
                        .addGap(0, 338, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel4)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(auth_method, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(getRCON, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(8, 8, 8)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(getPort, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(125, 125, 125)
                                                .addComponent(start_stop_button, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(announce_banned, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                                .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(announce_autokick, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jSeparator5)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel6))
                                    .addComponent(jSeparator7)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(getRCON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(getPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(auth_method, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(announce_autokick)
                        .addGap(7, 7, 7)
                        .addComponent(announce_banned)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(start_stop_button)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(26, 26, 26)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void getRCONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getRCONMouseClicked
        if (getRCON.getText().equals("Enter Server RCON")) {
            getRCON.setText("");
        }
    }//GEN-LAST:event_getRCONMouseClicked

    private void getPortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getPortMouseClicked
        if (getPort.getText().equals("Enter Server Port")) {
            getPort.setText("");
        }
    }//GEN-LAST:event_getPortMouseClicked

    private void start_stop_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_stop_buttonActionPerformed

        if (Main.isButtonPressed) {

            if (!getPort.getText().matches(".*\\d+.*")) {
                JOptionPane.showMessageDialog(null, "You Have Entered An Invalid Port. Please Enter Port Between 1 To 65534", "Invalid Server Port", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int Port = Integer.parseInt(getPort.getText());

            if (Port >= 0 && Port <= 65535) {
                // Do Nothing
            } else {
                JOptionPane.showMessageDialog(null, "You Have Entered An Invalid Port. Please Enter Port Between 1 To 65534", "Invalid Server Port", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Main.isButtonPressed = false;
            Main.isServiceStarted = true;
            start_stop_button.setText("Stop Server");

            if (auth_method.getSelectedItem().toString().contains("AEPEM v2 + AuthenticJoin")) {
                new SendInformation(getRCON.getText(), getPort.getText(), "AEPEM").start();
            } else {
                new SendInformation(getRCON.getText(), getPort.getText(), "Yes").start();
            }

            Main.isAnnounceAutoKick = announce_autokick.isSelected();
            Main.isAnnounceBanned = announce_banned.isSelected();

            getRCON.setEnabled(false);
            getPort.setEnabled(false);
            auth_method.setEnabled(false);
            announce_autokick.setEnabled(false);
            announce_banned.setEnabled(false);
        } else {
            Main.isServiceStarted = false;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
            }

            Main.isButtonPressed = true;
            getRCON.setEnabled(true);
            getPort.setEnabled(true);
            auth_method.setEnabled(true);
            announce_autokick.setEnabled(true);
            announce_banned.setEnabled(true);
            start_stop_button.setText("Start Server");
        }
    }//GEN-LAST:event_start_stop_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null, "IGI-2 Multiplayer Launcher Server Uplink v1.5        \n\nCreated By : Aayush Atharva        \nEmail : aayush@igi2.co.in                \nPhone: +1 (249) 700-1115       \nWebsite : www.igi-2.com\n", "About IGI-2 Multiplayer Launcher Server Uplink", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String Data = "                       " + "AEPEM v2 + AuthenticJoin : Automatic Encrypted Password Exchange Mechanism v2 With AuthenticJoin" + "\n\n"
                + "By Using This Method, Your Server Will Be Password Protected But Players Using Launcher will join server automatically and normally.\n"
                + "They Won't Have To Enter Any Password To Join Your Server. Launcher Will Automatically Fetch Your Password And Connect Players." + "\n\n"
                + "Reason To Use This: Your Server Will Be Safe From External Fake Players Attack. This Will Increase Your Server Security Level Against\n"
                + "In-Game Bugs. And This Will 100% Protect Server From Cheaters Or Hackers. \n\n"
                + "[ALWAYS USE THIS IF YOU RUN A PUBLIC AND OPEN SERVER]\n"
                + "\n\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n"
                + "                                                                                                           " + "Manual Password" + "\n\n"
                + "By Using This Method, You'll Set Your Server Password By Own. By Using This, Only Those Players Will Join Your Server Who You Know" + "\n"
                + "Your Server Password. Players Will Have To Enter Server Password To Connect To This Server." + "\n\n"
                + "Reason To Use This: You Allow Only Selected People On Your Server. This Method Also Increases Server Security Level" + "\n\n"
                + "[ALWAYS USE WHEN YOU ALLOW SELECTED PEOPLE TO SERVER]\n"
                + "\n\n";

        JOptionPane.showMessageDialog(null, Data, "About Authentication Method", JOptionPane.PLAIN_MESSAGE);

    }//GEN-LAST:event_jButton2ActionPerformed

    public static void setLog(String Data) {
        log_output.append(getDateTime() + Data + "\n");
        log_output.setCaretPosition(log_output.getDocument().getLength());
    }

    public static void setLog(String Date, String Data) {
        log_output.append(Date + Data + "\n");
        log_output.setCaretPosition(log_output.getDocument().getLength());
    }

    private static String getDateTime() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a zzz");
        return "[" + ft.format(dNow) + "] ";
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox announce_autokick;
    private javax.swing.JCheckBox announce_banned;
    private javax.swing.JComboBox<String> auth_method;
    private javax.swing.JTextField getPort;
    private javax.swing.JTextField getRCON;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private static javax.swing.JTextArea log_output;
    private javax.swing.JButton start_stop_button;
    // End of variables declaration//GEN-END:variables
}
