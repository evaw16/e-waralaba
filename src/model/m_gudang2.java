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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brian R
 */
public class m_gudang2 {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public m_gudang2() {
        try {
            connection = config.Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void simpanData(String id, String kode_barang, String jumlah) {
        try {
            String sql = "INSERT INTO tb_barangtoko values(NULL,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, kode_barang);
            preparedStatement.setString(3, jumlah);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void ubahData(String id, String kode_barang, String jumlah, String id_barangtoko) {
        try {
            String sql = "update tb_barangtoko set id = ? , kode_barang = ? , jumlah = ? where id_barangtoko = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, kode_barang);
            preparedStatement.setString(3, jumlah);
            preparedStatement.setString(4, id_barangtoko);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    private void hapusData(String id_barangtoko) {
        try {
            String sql = "delete from tb_barangtoko where id_barangtoko= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id_barangtoko);
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
            String sql = "select * from tb_barangtoko";
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

}
