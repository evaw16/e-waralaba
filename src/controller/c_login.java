/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.m_gudang1;
import model.m_login;
import view.Login;
import view.admin1;
import view.admin2;
import view.admin3;
import view.gudang1;
import view.gudang2;
import view.toko1;
import view.toko2;
import view.v_Admin;
import view.v_Gudang;
import view.v_Toko;

/**
 *
 * @author Brian R
 */
public class c_login {

    m_login model;
    Login login;

    public c_login(m_login m, Login v) {
        this.model = m;
        this.login = v;

        login.setVisible(true);
        login.getBtnLogin().addActionListener(new ButtonLogin());
        login.getPassword().addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key) {
                if (key.getKeyChar() == KeyEvent.VK_ENTER) {
                    login.getBtnLogin().doClick();
                }
            }
        });

    }

    private class ButtonLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String user = login.getUsername().getText();
            String pass = login.getPassword().getText();

            try {
                int status = model.getAkun(user, pass);
                if (status == 3) {
                    login.dispose();
                    toko1 t1 = new toko1();
                    toko2 t2 = new toko2();
                    v_Toko toko = new v_Toko(t1, t2);
                    toko.setVisible(true);
                } else if (status == 2) {
                    login.dispose();
                    gudang1 v1 = new gudang1();
                    gudang2 v2 = new gudang2();
                    v_Gudang gudang = new v_Gudang(v1, v2);
                    m_gudang1 m = new m_gudang1();
                    c_gudang1 c = new c_gudang1(m, v1);
                    gudang.setVisible(true);
                } else if (status == 1) {
                    login.dispose();
                    admin1 a1 = new admin1();
                    admin2 a2 = new admin2();
                    admin3 a3 = new admin3();
                    v_Admin admin = new v_Admin(a1, a2, a3);
                    admin.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Login Gagal !");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
