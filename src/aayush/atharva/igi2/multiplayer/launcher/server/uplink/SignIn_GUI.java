package aayush.atharva.igi2.multiplayer.launcher.server.uplink;

import javax.swing.JOptionPane;

public class SignIn_GUI extends javax.swing.JFrame {

    public static String Remember_Login = "NO";

    public SignIn_GUI() {
        initComponents();     // Start Components
        setVisible(true);     // Make GUI Visible
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        email_username = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        signin_button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        status_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome To IGI-2 Multiplayer Launcher Server Uplink");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(230, 230, 230));
        jPanel2.setForeground(new java.awt.Color(230, 230, 230));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Login To Continue");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 160, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 550, 10));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Username / Email");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 160, 38));

        email_username.setBackground(new java.awt.Color(230, 230, 230));
        email_username.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        email_username.setText("Enter Your Username or Email");
        email_username.setToolTipText("Enter Your Email");
        email_username.setBorder(null);
        email_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                email_usernameMouseClicked(evt);
            }
        });
        jPanel2.add(email_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 370, 28));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 371, 10));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setText("Password");
        jLabel4.setToolTipText("");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 115, -1));

        password.setBackground(new java.awt.Color(230, 230, 230));
        password.setText("jPasswordField1");
        password.setBorder(null);
        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordMouseClicked(evt);
            }
        });
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 380, 29));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 371, 10));

        signin_button.setBackground(new java.awt.Color(106, 153, 231));
        signin_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signin_button.setText("Sign In");
        signin_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signin_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(signin_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 180, 40));

        jLabel5.setText("jLabel5");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-410, 190, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 246, 10));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setText("Welcome To IGI-2 Multiplayer Launcher Server Uplink");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 480, 30));

        status_label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        status_label.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(status_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 620, 100, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void email_usernameMouseClicked(java.awt.event.MouseEvent evt) {
        if (email_username.getText().equals("Enter Your Username or Email")) {
            email_username.setText("");
        }
    }

    private void signin_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signin_buttonActionPerformed

        try {
            signin_button.setText("Signin In...");

            new Sign_In(email_username.getText(), password.getText()).SignIn();

            if (Main.Authentication_Check.equals("Yes Autheneitcated, Authentication Completed...")) {
                dispose();
            }

            if (!Main.Authentication_Check.equals("Yes Autheneitcated, Authentication Completed...")) {
                signin_button.setText("Sign In");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unable To Process Sign In\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 113", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }//GEN-LAST:event_signin_buttonActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed

    }//GEN-LAST:event_passwordActionPerformed

    private void passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseClicked
        password.setText("");
    }//GEN-LAST:event_passwordMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField email_username;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    public static javax.swing.JPasswordField password;
    private static javax.swing.JButton signin_button;
    public static javax.swing.JLabel status_label;
    // End of variables declaration//GEN-END:variables

}
