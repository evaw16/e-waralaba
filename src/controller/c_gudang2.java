/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import model.m_gudang2;
import view.gudang2;

/**
 *
 * @author Brian R
 */
public class c_gudang2 {

    m_gudang2 model = new m_gudang2();
    gudang2 view;
    int tokoTerpilih;

    public c_gudang2(m_gudang2 m, gudang2 v) throws SQLException {
        this.model = m;
        this.view = v;
        view.setVisible(true);
        comboUser();
        comboBarang();
        view.getBtnSimpan().addActionListener(new ButtonSimpan());
        view.getBtnUbah().addActionListener(new ButtonUbah());
        view.getBtnReset().addActionListener(new ButtonReset());
        view.getBtnHapus().addActionListener(new ButtonHapus());
        view.setTabel(view.getTable_gudang2(), model.tableGudang1());
    }

    public void comboUser() {
        HashMap<String, Integer> map = model.comboUsers();
        for (String s : map.keySet()) {
            view.setDdUsers(s);
        }
    }

    public void comboBarang() {
        HashMap<String, Integer> map = model.comboBarang();
        for (String s : map.keySet()) {
            view.setDdBarang(s);
        }
    }

    private class ButtonSimpan implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                HashMap<String, Integer> mapUser = model.comboUsers();
                int id = Integer.parseInt(mapUser.get(view.getDdUsers().getSelectedItem().toString()).toString());
                HashMap<String, Integer> mapBarang = model.comboBarang();
                int kode_barang = Integer.parseInt(mapBarang.get(view.getDdBarang().getSelectedItem().toString()).toString());
                int jumlah = Integer.parseInt(view.getJumlah_field().getText());
                model.simpanData(id, kode_barang, jumlah);
                view.setTabel(view.getTable_gudang2(), model.tableGudang1());
                clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private class ButtonUbah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class ButtonReset implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            clear();
        }
    }

    private class ButtonHapus implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

        }
    }

    private void clear() {
        String clear = "";
        view.setJumlah_field(clear);
    }

}
