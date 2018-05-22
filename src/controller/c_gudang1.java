/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.m_gudang1;
import view.gudang1;

/**
 *
 * @author Brian R
 */
public class c_gudang1 {

    m_gudang1 model;
    gudang1 gudang;

    public c_gudang1(m_gudang1 m, gudang1 v) {
        this.model = m;
        this.gudang = v;
//        gudang = new gudang1();
        gudang.setVisible(true);
        gudang.getBtnSimpan().addActionListener(new ButtonSimpan());
        gudang.getBtnUbah().addActionListener(new ButtonUbah());
        gudang.getBtnHapus().addActionListener(new ButtonHapus());//bisa
        gudang.getBtnReset().addActionListener(new ButtonReset());//bisa
        gudang.setTabel(gudang.getTable_barang(), model.tableGudang1());

    }

    private class ButtonReset implements ActionListener {

        public ButtonReset() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                clear();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private class ButtonHapus implements ActionListener {

        public ButtonHapus() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            int kodeBarang = Integer.parseInt(gudang.getKode_barang().getText());
            try {
                model.hapusData(kodeBarang);
                gudang.setTabel(gudang.getTable_barang(), model.tableGudang1());
                clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private class ButtonUbah implements ActionListener {

        public ButtonUbah() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            String namaBarang = gudang.getNama_barang().getText();
            int jumlahStok = Integer.parseInt(gudang.getJumlah_stok().getText());
            int hargaBarang = Integer.parseInt(gudang.getHarga_barang().getText());
            int kodeBarang = Integer.parseInt(gudang.getKode_barang().getText());
            try {
                model.updateData(namaBarang, jumlahStok, hargaBarang, kodeBarang);
                gudang.setTabel(gudang.getTable_barang(), model.tableGudang1());
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
            String namaBarang = gudang.getNama_barang().getText();
            int jumlahStok = Integer.parseInt(gudang.getJumlah_stok().getText());
            int hargaBarang = Integer.parseInt(gudang.getHarga_barang().getText());
            try {
                model.simpanData(namaBarang, jumlahStok, hargaBarang);
                gudang.setTabel(gudang.getTable_barang(), model.tableGudang1());
                clear();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private void clear() {
        String clear = "";
        gudang.setKode_barang(clear);
        gudang.setHarga_barang(clear);
        gudang.setNama_barang(clear);
        gudang.setJumlah_stok(clear);
    }

}
