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
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import model.m_gudang2;
import view.gudang2;

/**
 *
 * @author Brian R
 */
public class c_gudang2 {

    m_gudang2 model;
    gudang2 view;
    String[][] user;
    int tokoTerpilih;
    public c_gudang2(m_gudang2 m, gudang2 v) throws SQLException {
        this.model = m;
        this.view = v;
        view.setVisible(true);
        view.getBtnSimpan().addActionListener(new ButtonSimpan());
        view.getBtnUbah().addActionListener(new ButtonUbah());
        view.getBtnReset().addActionListener(new ButtonReset());
        view.getBtnHapus().addActionListener(new ButtonHapus());
        view.setTabel(view.getTable_gudang2(), model.tableGudang1());
//        view.getDdUsers().setModel(getUser());
//        view.getDdUsers().addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent me) {
//                tokoTerpilih = view.getDdUsers().getSelectedIndex();
//                System.out.println(tokoTerpilih);
//            }
//
//            @Override
//            public void mousePressed(MouseEvent me) {
//                
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent me) {
//                
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent me) {
//                
//            }
//
//            @Override
//            public void mouseExited(MouseEvent me) {
//                
//            }
//        });
//        
//        view.getDdBarang().setModel(getBarang());
    }

    private ComboBoxModel<String> getUser() throws SQLException {
        user = model.getUser();
        DefaultComboBoxModel model = new DefaultComboBoxModel(user[1]);
        return model;
    }
    private ComboBoxModel<String> getBarang() {
//        user = model.getBarang(0);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        return model;
    }

    private class ButtonSimpan implements ActionListener {

        public ButtonSimpan() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {

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
