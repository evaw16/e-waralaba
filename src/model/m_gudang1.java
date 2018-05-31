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
import javax.swing.table.DefaultTableModel;
import view.gudang1;

/**
 *
 * @author Brian R
 */
public class m_gudang1 extends config{

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    

    public m_gudang1() {
        try {
            connection = Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void simpanData(String namaBarang, int jumlahStok, int hargaBarang) {
//        String sql = "INSERT INTO barang values(" + kodeBarang + ",'" + namaBarang + "'," + jumlahStok + "," + hargaBarang + ")";
        try {
//            String sql = "INSERT INTO barang values(NULL,?,?,?)";
            String sql = "insert into barang (nama_barang,jumlah_stok,harga) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, namaBarang);
            preparedStatement.setInt(2, jumlahStok);
            preparedStatement.setInt(3, hargaBarang);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
//        statement = connection.createStatement();
//        statement.executeUpdate(sql);

    }

    public void updateData(String namaBarang, int jumlahStok, int hargaBarang, int kodeBarang) throws SQLException {
        String sql = "update barang set (nama_barang,jumlah_stok,harga) = (?,?,?) where kode_barang= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, kodeBarang);
        preparedStatement.setString(1, namaBarang);
        preparedStatement.setInt(2, jumlahStok);
        preparedStatement.setInt(3, hargaBarang);
        preparedStatement.setInt(4, kodeBarang);
        preparedStatement.executeUpdate();
    }

    public void hapusData(int kodeBarang) throws SQLException {
        String sql = "delete from barang where kode_barang= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, kodeBarang);
        preparedStatement.executeUpdate();

    }

    public DefaultTableModel tableGudang1() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah Stok");
        model.addColumn("Harga");
        try {
            String sql = "select * from barang";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            int no = 0;
            while (resultSet.next()) {
                no++;
                model.addRow(new Object[]{
                    resultSet.getString("kode_barang"), resultSet.getString("nama_barang"), resultSet.getString("jumlah_stok"), resultSet.getString("harga")
                });
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;

    }

}
