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
public class m_admin2 extends config {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public m_admin2() {
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
            System.out.println(e.getMessage());
        }
        return model;

    }

}
