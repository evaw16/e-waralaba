/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.m_toko2;
import view.toko2;

/**
 *
 * @author Brian R
 */
public class c_toko2 {
    m_toko2 model;
    toko2 view;

    public c_toko2(m_toko2 m, toko2 v) {
        this.model = m;
        this.view = v;
        view.setVisible(true);
        view.setTable_barang(view.getTable_barang(), model.tableToko1());
    }
    
    
}
