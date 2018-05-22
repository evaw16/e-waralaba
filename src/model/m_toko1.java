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
import java.sql.Date;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

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

    public void simpanData(int barang_toko, Date tanggal, int jumlah_penjualan) {
        try {
            String sql = "INSERT INTO tb_penjualan (id_penjualan,tanggal_penjualan,jumlah_penjualan) values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, barang_toko);
            preparedStatement.setObject(2, tanggal);
            preparedStatement.setInt(3, jumlah_penjualan);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void ubahData(int barang_toko, Date tanggal, int jumlah_penjualan, int id_penjualan) {
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void hapusData(int id_penjualan) {
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public HashMap<String, Integer> comboBarang() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        try {
            String sql = "select tb.id_barangtoko,b.nama_barang from barang b join tb_barangtokoo tb on b.kode_barang = tb.kode_barang";
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

    public DefaultTableModel tableToko1() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Kode Barang");
        model.addColumn("Tanggal");
        model.addColumn("Jumlah Penjualan");
        try {
            String sql = "select * from tb_penjualan p join tb_barangtokoo b on p.id_penjualan = b.id_barangtoko";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            int no = 0;
            while (resultSet.next()) {
                no++;
                model.addRow(new Object[]{
                    resultSet.getString("id_penjualan"), resultSet.getString("kode_barang"), resultSet.getString("tanggal_penjualan"), resultSet.getString("jumlah_penjualan")
                });
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;

    }

}
