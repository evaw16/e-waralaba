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

//    public Object[] getUsers() throws SQLException {
//        ArrayList<String> grupNama = new ArrayList<String>();
//        String query = "select * from users where status = 3 order by username";
//        ResultSet rs = statement.executeQuery(query);
//
//        while (rs.next()) {
//            String groupName = rs.getString("username");
//            grupNama.add(groupName);
//        }
//
//        rs.close();
//        return grupNama.toArray();
//    }
//
//    public String getId(Object id) throws SQLException {
//        String sql = "select u.* from users u join tb_barangtokoo tb on u.id = tb.id where u.id = ?";
//        connection = config.Connection();
//        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
//        preparedStatement.setObject(1, id);
//        resultSet = preparedStatement.executeQuery();
//        resultSet.next();
//        String user = resultSet.getString("id");
//        return user;
//    }
//
//    public Object[] getBarang() throws SQLException {
//        ArrayList<String> grupNama = new ArrayList<String>();
//        String query = "select * from barang order by nama_barang";
//        ResultSet rs = statement.executeQuery(query);
//
//        while (rs.next()) {
//            String groupName = rs.getString("nama_barang");
//            grupNama.add(groupName);
//        }
//
//        rs.close();
//        return grupNama.toArray();
//    }
//
//    public String getKode(Object kode_barang) throws SQLException {
//        String sql = "select b.* from barang b join tb_barangtokoo tb on b.kode_barang = tb.kode_barang where kode_barang = ?";
//        connection = config.Connection();
//        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
//        preparedStatement.setObject(1, kode_barang);
//        resultSet = preparedStatement.executeQuery();
//        resultSet.next();
//        String user = resultSet.getString("barang");
//        return user;
//    }
//
//    public String[][] getUser() throws SQLException {
//        String sql = "Select id , username from users where status = 3;";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        resultSet = preparedStatement.executeQuery();
//        int row = 0;
//        while (resultSet.next()) {
//            row++;
//        }
//        System.out.println(row);
//        String user[][] = new String[2][row];
//        resultSet.beforeFirst();
//        for (int i = 0; i < row; i++) {
//            user[0][i] = resultSet.getString(1);
//            user[1][i] = resultSet.getString(2);
//        }
//        return user;
//    }
//
//    public String[][] getBarang(int id) throws SQLException {
//        String sql = "SELECT tb_barangtokoo.id, barang.* FROM.barang tb_barangtokoo ON tb_barangtokoo.kode_barang = barang.kode_barang JOIN users ON tb_barangtokoo.id = users.id WHERE tb_barangtokoo.id = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, id);
//        resultSet = preparedStatement.executeQuery();
//        int row = 0;
//        while (resultSet.next()) {
//            row++;
//        }
//        String user[][] = new String[2][row];
//        resultSet.beforeFirst();
//        for (int i = 0; i < row; i++) {
//            user[0][i] = resultSet.getString(1);
//            user[1][i] = resultSet.getString(2);
//        }
//        return user;
//    }

    public void simpanData(String id, String kode_barang, String jumlah) {
        try {
            String sql = "INSERT INTO tb_barangtokoo values(?,?,?)";
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
            String sql = "update tb_barangtokoo set id = ? , kode_barang = ? , jumlah = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, kode_barang);
            preparedStatement.setString(3, jumlah);
            preparedStatement.setString(4, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    private void hapusData(String id) {
        try {
            String sql = "delete from tb_barangtokoo where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
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
