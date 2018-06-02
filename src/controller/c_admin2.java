/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.m_admin2;
import view.admin2;

/**
 *
 * @author Brian R
 */
public class c_admin2 {
    m_admin2 model;
    admin2 view;

    public c_admin2(m_admin2 m, admin2 v) {
        this.model = m;
        this.view = v;
        view.setVisible(true);
        view.setTable_barang(view.getTable_barang(), model.tableToko1());
    }
}
