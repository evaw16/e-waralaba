/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connector.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Brian R
 */
public class m_toko1 {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    public m_toko1() {
        try {
            connection = config.Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public HashMap<String, Integer> comboBarang() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        try {
            String sql = "select tb.kode_barang,b.nama_barang from barang b join tb_barangtokoo tb on b.kode_barang = tb.kode_barang";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            m_combogudang m;

            while (resultSet.next()) {
                m = new m_combogudang(resultSet.getInt(1), resultSet.getString(2));
                map.put(m.getUsername(), m.getId());
            }
        } catch (Exception e) {
            System.out.println("salah");
        }
        return map;
    }

}
