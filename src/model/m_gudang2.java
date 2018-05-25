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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brian R
 */
public class m_gudang2 {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    public m_gudang2() {
        try {
            connection = config.Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void simpanData(int id, int kode_barang, int jumlah) {
        try {
            String sql = "INSERT INTO tb_barangtokoo (id,kode_barang,jumlah) values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, kode_barang);
            preparedStatement.setInt(3, jumlah);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void ubahData(int id, int kode_barang, int jumlah, int id_barangtoko) {
        try {
            String sql = "update tb_barangtokoo set id = ? , kode_barang = ? , jumlah = ? where id_barangtoko = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, kode_barang);
            preparedStatement.setInt(3, jumlah);
            preparedStatement.setInt(4, id_barangtoko);
            preparedStatement.executeUpdate();
            System.out.println("asd");
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void hapusData(int id_barangtoko) {
        try {
            String sql = "delete from tb_barangtokoo where id_barangtoko = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_barangtoko);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public DefaultTableModel tableGudang1() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Id Toko");
        model.addColumn("Id Barang");
        model.addColumn("Jumlah");
        try {
            String sql = "select * from tb_barangtokoo";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            int no = 0;
            while (resultSet.next()) {
                no++;
                model.addRow(new Object[]{
                    resultSet.getString("id_barangtoko"), resultSet.getString("id"), resultSet.getString("kode_barang"), resultSet.getString("jumlah")
                });
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;

    }

    public HashMap<String, Integer> comboUsers() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        try {
            String sql = "select id,username from users where status = 3";
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

    public HashMap<String, Integer> comboBarang() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        try {
            String sql = "select kode_barang,nama_barang from barang";
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
