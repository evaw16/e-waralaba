/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.m_gudang1;
import model.m_login;
import view.Login;
import view.gudang1;
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
                    v_Toko toko = new v_Toko();
                    toko.setVisible(true);
                } else if (status == 2) {
                    login.dispose();
                    v_Gudang gudang = new v_Gudang();
                    gudang1 v = new gudang1();
                    m_gudang1 m = new m_gudang1();
                    c_gudang1 c = new c_gudang1(m, v);
                    gudang.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Login Gagal !");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
