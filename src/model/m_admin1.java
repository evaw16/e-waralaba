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
public class m_admin1 {

    Connection connection = config.Connection();
    Statement statement;
    ResultSet resultSet;

    public m_admin1() {
        try {
            connection = config.Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void simpanData(String nameAdmin1, String userAdmin1, String passAdmin1) {
        int status = 3;
        try {
            String sql = "INSERT INTO users values(NULL,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nameAdmin1);
            preparedStatement.setString(2, userAdmin1);
            preparedStatement.setString(3, passAdmin1);
            preparedStatement.setInt(4, status);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void ubahData(String nameAdmin1, String userAdmin1, String passAdmin1, String idAdmin1) {
        try {
            String sql = "update users set nama = ? , username = ? , password = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nameAdmin1);
            preparedStatement.setString(2, userAdmin1);
            preparedStatement.setString(3, passAdmin1);
            preparedStatement.setString(4, idAdmin1);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void hapusData(String idAdmin1) {
        try {
            String sql = "delete from users where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, idAdmin1);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public DefaultTableModel tableAdmin1() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nama");
        model.addColumn("Username");
        model.addColumn("Password");
        try {
            String sql = "select * from users";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            int no = 0;
            while (resultSet.next()) {
                no++;
                model.addRow(new Object[]{
                    resultSet.getString("id"), resultSet.getString("nama"), resultSet.getString("username"), resultSet.getString("password")
                });
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;

    }
}
