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
    
    public String[][] getUser() throws SQLException {
        String sql = "Select id , username from users where status = 3;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        int row = 0;
        while (resultSet.next()) {
            row++;
        }
        System.out.println(row);
        String user[][] = new String[2][row];
        resultSet.beforeFirst();
        for (int i = 0; i < row; i++) {
            user[0][i] = resultSet.getString(1);
            user[1][i] = resultSet.getString(2);
        }
        return user;
    }

    public String[][] getBarang(int id) throws SQLException {
        String sql = "SELECT tb_barangtokoo.id, barang.* FROM.barang tb_barangtokoo ON tb_barangtokoo.kode_barang = barang.kode_barang JOIN users ON tb_barangtokoo.id = users.id WHERE tb_barangtokoo.id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        int row = 0;
        while (resultSet.next()) {
            row++;
        }
        String user[][] = new String[2][row];
        resultSet.beforeFirst();
        for (int i = 0; i < row; i++) {
            user[0][i] = resultSet.getString(1);
            user[1][i] = resultSet.getString(2);
        }
        return user;
    }
    
    public void simpanData(String id, String kode_barang, String jumlah) {
        try {
            String sql = "INSERT INTO tb_barangtokoo values(NULL,?,?,?)";
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
            String sql = "update tb_barangtokoo set id = ? , kode_barang = ? , jumlah = ? where id_barangtoko = ?";
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
            String sql = "delete from tb_barangtokoo where id_barangtokoo= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id_barangtoko);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public DefaultTableModel tableGudang1() {
        DefaultTableModel model = new DefaultTableModel();
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
                    resultSet.getString("id"), resultSet.getString("kode_barang"), resultSet.getString("jumlah")
                });
            }
            
        } catch (Exception e) {
            e.getMessage();
        }
        return model;
        
    }
    
}
