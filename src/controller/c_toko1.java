/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.HashMap;
import java.util.Locale;
import model.m_toko1;
import view.toko1;
import view.v_Toko;

/**
 *
 * @author Brian R
 */
public class c_toko1 {

    toko1 view;
    m_toko1 model;

    public c_toko1(toko1 v, m_toko1 m) {
        this.view = v;
        this.model = m;
        view.setVisible(true);
        view.getBtnSimpan().addActionListener(new ButtonSimpan());
        view.getBtnUbah().addActionListener(new ButtonUbah());
        view.getBtnReset().addActionListener(new ButtonReset());
        view.getBtnHapus().addActionListener(new ButtonHapus());
        view.setTabel(view.getTable_penjualan(), model.tableToko1());
        comboBarang();
    }

    public void comboBarang() {
        HashMap<String, Integer> map = model.comboBarang();
        for (String s : map.keySet()) {
            view.setDdToko(s);
        }
    }

    private class ButtonHapus implements ActionListener {

        public ButtonHapus() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                int id_penjualan = Integer.parseInt(view.getId_penjualan().getText());
                String tanggal = view.getTanggal(view.Tanggal()).toString();
                Date date = Date.valueOf(tanggal);
                model.hapusData(id_penjualan,date);
                view.setTabel(view.getTable_penjualan(), model.tableToko1());
                clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
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

    private class ButtonUbah implements ActionListener {

        public ButtonUbah() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                int id_penjualan = Integer.parseInt(view.getId_penjualan().getText());
                String tanggal = view.getTanggal(view.Tanggal()).toString();
                Date date = Date.valueOf(tanggal);
                HashMap<String, Integer> mapBarang = model.comboBarang();
                int kode_barang = Integer.parseInt(mapBarang.get(view.getDdToko().getSelectedItem().toString()).toString());
                int jumlah_penjualan = Integer.parseInt(view.getJumlah_terjual().getText());
                model.ubahData(kode_barang, date, jumlah_penjualan, id_penjualan);
                view.setTabel(view.getTable_penjualan(), model.tableToko1());
                clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private class ButtonSimpan implements ActionListener {

        public ButtonSimpan() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String tanggal = view.getTanggal(view.Tanggal()).toString();
                Date date = Date.valueOf(tanggal);
                HashMap<String, Integer> mapBarang = model.comboBarang();
                int kode_barang = Integer.parseInt(mapBarang.get(view.getDdToko().getSelectedItem().toString()).toString());
                int jumlah_penjualan = Integer.parseInt(view.getJumlah_terjual().getText());
                model.simpanData(kode_barang, date, jumlah_penjualan);
                view.setTabel(view.getTable_penjualan(), model.tableToko1());
                clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void clear() {
        String clear = "";
        view.setJumlah_terjual(clear);
        view.Tanggal().setDate(null);
        view.setId_penjualan(clear);
    }

}
