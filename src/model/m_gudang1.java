/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//import com.mysql.jdbc.PreparedStatement;
import connector.config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author Brian R
 */
public class m_gudang1 {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public m_gudang1() {
        try {
            connection = config.Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void simpanData(String namaBarang, int jumlahStok, int hargaBarang) {
//        String sql = "INSERT INTO barang values(" + kodeBarang + ",'" + namaBarang + "'," + jumlahStok + "," + hargaBarang + ")";
        try {
            String sql = "INSERT INTO barang values(NULL,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, namaBarang);
            preparedStatement.setInt(3, jumlahStok);
            preparedStatement.setInt(4, hargaBarang);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
//        statement = connection.createStatement();
//        statement.executeUpdate(sql);

    }

    public void updateData(String kodeBarang, String namaBarang, String jumlahStok, String hargaBarang) throws SQLException {
        String sql = "update barang set kode_barang= ?, nama_barang = ?jumlah_stok= ? harga= ? where kode_barang= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, kodeBarang);
        preparedStatement.setString(2, namaBarang);
        preparedStatement.setString(3, jumlahStok);
        preparedStatement.setString(4, hargaBarang);
        preparedStatement.setString(5, kodeBarang);
        preparedStatement.executeUpdate();
    }

    public void hapusData(String kodeBarang) throws SQLException {
        String sql = "delete from barang where kode_barang= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, kodeBarang);
        preparedStatement.executeUpdate();

    }

}
