/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.m_admin1;
import view.admin1;

/**
 *
 * @author Brian R
 */
public class c_admin1 {

    m_admin1 model;
    admin1 view;

    public c_admin1(m_admin1 m, admin1 v) {
        this.model = m;
        this.view = v;
        view.setVisible(true);
        view.getBtnSimpan().addActionListener(new ButtonSimpan());
        view.getBtnUbah().addActionListener(new ButtonUbah());
        view.getBtnHapus().addActionListener(new ButtonHapus());
        view.getBtnReset().addActionListener(new ButtonReset());
        view.setTabel(view.getTable_users(), model.tableAdmin1());
    }

    private class ButtonSimpan implements ActionListener {

        public ButtonSimpan() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            String name = view.getNameAdmin1().getText();
            String username = view.getUserAdmin1().getText();
            String password = view.getPassAdmin1().getText();
            if (name.equalsIgnoreCase("") || username.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } else {
                try {
                    model.simpanData(name, username, password);
                    view.setTabel(view.getTable_users(), model.tableAdmin1());
                    clear();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
    }

    private class ButtonUbah implements ActionListener {

        public ButtonUbah() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            String name = view.getNameAdmin1().getText();
            String username = view.getUserAdmin1().getText();
            String password = view.getPassAdmin1().getText();
            int id = Integer.parseInt(view.getIdAdmin1().getText());
            if (name.equalsIgnoreCase("") || username.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } else {
                try {
                    model.ubahData(name, username, password, id);
                    view.setTabel(view.getTable_users(), model.tableAdmin1());
                    clear();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
    }

    private class ButtonHapus implements ActionListener {

        public ButtonHapus() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            int id = Integer.parseInt(view.getIdAdmin1().getText());
            try {
                model.hapusData(id);
                view.setTabel(view.getTable_users(), model.tableAdmin1());
                clear();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    private class ButtonReset implements ActionListener {

        public ButtonReset() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            clear();
        }
    }

    private void clear() {
        String clear = "";
        view.setIdAdmin1(clear);
        view.setNameAdmin1(clear);
        view.setUserAdmin1(clear);
        view.setPassAdmin1(clear);
    }

}
