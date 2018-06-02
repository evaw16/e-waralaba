/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connector.config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brian R
 */
public class m_toko2 extends config {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    int id;
    public m_toko2(int id) {
        this.id = id;
        try {
            connection = Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public DefaultTableModel tableToko1() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah Stok");
        model.addColumn("Harga");
        try {
            String sql = "select * from barang b join tb_barangtokoo tb on b.kode_barang = tb.kode_barang where tb.id =" + id;
            System.out.println(id);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            int no = 0;
            while (resultSet.next()) {
                no++;
                model.addRow(new Object[]{
                    resultSet.getString("kode_barang"), resultSet.getString("nama_barang"), resultSet.getString("jumlah"), resultSet.getString("harga")
                });
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;

    }

}
