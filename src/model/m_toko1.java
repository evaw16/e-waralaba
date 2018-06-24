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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brian R
 */
public class m_toko1 extends config{

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    public int id;

    public m_toko1(int id) {
        this.id = id;
        try {
            connection = Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void simpanData(int barang_toko, Date tanggal, int jumlah_penjualan) {
        int result = 10;
        try {
            String sql = "select * from tb_barangtokoo where id_barangtoko = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, barang_toko);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result = resultSet.getInt("jumlah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (result >= jumlah_penjualan) {
            int total = result - jumlah_penjualan;
            try {
                String sql = "update tb_barangtokoo set (jumlah) = (?) where id= ? and id_barangtoko = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, total);
                preparedStatement.setInt(2, id);
                preparedStatement.setInt(3, barang_toko);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
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
        } else{
            JOptionPane.showMessageDialog(null, "Jumlah Stok kosong");
        }
    }

    public void ubahData(int barang_toko, Date tanggal, int jumlah_penjualan, int id_penjualan) {
        try {
            String sql = "update tb_penjualan set id_penjualan = ? , tanggal_penjualan = ? , jumlah_penjualan = ? where id_penjualan = ? and tanggal_penjualan = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, barang_toko);
            preparedStatement.setObject(2, tanggal);
            preparedStatement.setInt(3, jumlah_penjualan);
            preparedStatement.setInt(4, id_penjualan);
            preparedStatement.setObject(5, tanggal);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void hapusData(int id_penjualan, Date tanggal) {
        try {
            String sql = "delete from tb_penjualan where id_penjualan = ? and tanggal_penjualan = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_penjualan);
            preparedStatement.setObject(2, tanggal);
            preparedStatement.executeUpdate();
            System.out.println(id_penjualan);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public HashMap<String, Integer> comboBarang() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        try {
            String sql = "select tb.id_barangtoko,b.nama_barang from barang b join tb_barangtokoo tb on b.kode_barang = tb.kode_barang where tb.id =" + id;
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
        model.addColumn("Nama Barang");
        model.addColumn("Tanggal");
        model.addColumn("Jumlah Penjualan");
        try {
            String sql = "select * from tb_penjualan p join tb_barangtokoo b on p.id_penjualan = b.id_barangtoko join barang ba on b.kode_barang = ba.kode_barang where id =" + id;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            int no = 0;
            while (resultSet.next()) {
                no++;
                model.addRow(new Object[]{
                    resultSet.getString("id_penjualan"), resultSet.getString("nama_barang"), resultSet.getString("tanggal_penjualan"), resultSet.getString("jumlah_penjualan")
                });
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;

    }

}
