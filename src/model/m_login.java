/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import connector.config;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static view.Login.status;
import view.v_Gudang;
import view.v_Toko;
import view.Login;

/**
 *
 * @author Brian R
 */
public class m_login extends config{

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public m_login() {
        try {
            connection = Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int[] getAkun(String user, String pass) throws SQLException {
        status = new int[2];
        String sql = "select * from users where username = ? and password = ?";
        connection = Connection();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, pass);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        status[0] = resultSet.getInt("id");
        status[1] = resultSet.getInt("status");
        return status;
    }

    public String getUsername(int id) throws SQLException {
        String sql = "select * from users where id = ?";
        connection = Connection();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        String user = resultSet.getString("username");
        return user;
    }

    public int getId(int id) throws SQLException {
        String sql = "select id from users where id = ?";
        connection = Connection();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int id1 = resultSet.getInt("id");
        return id1;
    }

}
