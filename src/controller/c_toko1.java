/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.HashMap;
import model.m_toko1;
import view.toko1;

/**
 *
 * @author Brian R
 */
public class c_toko1 {
    toko1 view;
    m_toko1 model;

    public c_toko1(toko1 v, m_toko1 m) throws SQLException{
        this.view = v;
        this.model = m;
        view.setVisible(true);
        comboBarang();
    }
    
    public void comboBarang() {
        HashMap<String, Integer> map = model.comboBarang();
        for (String s : map.keySet()) {
            view.setDdToko(s);
        }
    }
    
    
}
