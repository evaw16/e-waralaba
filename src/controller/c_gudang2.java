/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.m_gudang2;
import view.gudang2;

/**
 *
 * @author Brian R
 */
public class c_gudang2 {

    m_gudang2 model;
    gudang2 view;

    public c_gudang2(m_gudang2 m, gudang2 v) {
        this.model = m;
        this.view = v;
        view.setVisible(true);
        view.getBtnSimpan().addActionListener(new ButtonSimpan());
        view.getBtnUbah().addActionListener(new ButtonUbah());
        view.getBtnReset().addActionListener(new ButtonReset());
        view.getBtnHapus().addActionListener(new ButtonHapus());
    }

    private class ButtonSimpan implements ActionListener {

        public ButtonSimpan() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class ButtonUbah implements ActionListener {

        public ButtonUbah() {
        }

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

        public ButtonHapus() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
    }

    private void clear() {
        String clear = "";
        view.setJumlah_field(clear);
    }

}
