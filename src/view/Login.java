/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import connector.config;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Brian R
 */
public class Login extends javax.swing.JFrame {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    public static int status[];
//    public static int id;
    private String user;
    private String pass;

    public Login() {
        initComponents();
        btnLogin.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
//        btnLogin.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                try {
//                    user = username.getText();
//                    pass = password.getText();
//
//                    String sql = "select * from users where username='" + user + "' and password='" + pass + "'";
//
//                    connection = config.Connection();
//                    statement = connection.createStatement();
//                    resultSet = statement.executeQuery(sql);
//                    if (resultSet.next()) {
//                        if (null == resultSet.getString("status")) {
//                            status = resultSet.getInt("status");
//                        } else {
//                            switch (resultSet.getInt("status")) {
//                                case 1:
//                                    break;
//                                case 2:
//                                    dispose();
//                                    v_Gudang gudang = new v_Gudang();
//                                    gudang.setVisible(true);
//                                    break;
//                                case 3:
//                                    dispose();
//                                    v_Toko toko = new v_Toko();
//                                    toko.setVisible(true);
//                                    break;
//                                default:
//                                    break;
//                            }
//                        }
//
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Login Gagal !");
//                    }
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        }
//        );
        showPassword.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                showPass();
            }
        }
        );
        username.setToolTipText("Masukkan username dengan benar");
        password.setToolTipText("Masukkan password dengan benar");
        

    }

    private void loginError(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Username / Password anda salah !1!1");
    }

    private void showPass() {
        if (showPassword.isSelected()) {
            password.setEchoChar((char) 0);
        } else {
            password.setEchoChar('*');
        }
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public JTextField getUsername() {
        return username;
    }

    public JCheckBox getShowPassword() {
        return showPassword;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        showPassword = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("E-Waralaba");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 280, 40));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 280, 40));

        showPassword.setText("Show Password");
        getContentPane().add(showPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnLogin.png"))); // NOI18N
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 419, 120, 50));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnHide1.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 30, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnExit1.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 30, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgLogin.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setState(ICONIFIED);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JCheckBox showPassword;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
