/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import model.m_admin3;
import view.admin3;

/**
 *
 * @author Brian R
 */
public class c_admin3 {

    m_admin3 model;
    admin3 view;
    int id_user = 0;

    public c_admin3(m_admin3 m, admin3 v) {
        this.model = m;
        this.view = v;
        view.setVisible(true);
        comboUser();
        view.getDdUsers().addActionListener(new ButtonAction());
        HashMap<String, Integer> mapUser = model.comboUsers();
        int id = Integer.parseInt(mapUser.get(view.getDdUsers().getSelectedItem().toString()).toString());
        comboBarang(id);
        view.getjButton1().addActionListener(new ButtonChart());
    }

    public void comboUser() {
        HashMap<String, Integer> map = model.comboUsers();
        for (String s : map.keySet()) {
            view.setDdUser(s);
        }
    }

    public void comboBarang(int id) {
        id_user = id;
        HashMap<String, Integer> map = model.comboBarangg(id_user);
        for (String s : map.keySet()) {
            view.setDdBarang(s);
        }
    }

    private class ButtonAction implements ActionListener {

        public ButtonAction() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            HashMap<String, Integer> mapUser = model.comboUsers();
            int id = Integer.parseInt(mapUser.get(view.getDdUsers().getSelectedItem().toString()).toString());
            comboBarang(id);
            System.out.println(id);
        }
    }

    private class ButtonChart implements ActionListener {

        public ButtonChart() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            HashMap<String, Integer> mapUser = model.comboUsers();
            int id = Integer.parseInt(mapUser.get(view.getDdUsers().getSelectedItem().toString()).toString());
            HashMap<String , Integer> mapBarang = model.comboBarangg(id);
            int kode_barang = Integer.parseInt(mapBarang.get(view.getDdBarang().getSelectedItem().toString()).toString());
            model.chart(id);
        }
    }

}
