/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import connector.config;
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
public class m_login {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public m_login() {
        try {
            connection = config.Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getAkun(String user, String pass) throws SQLException {

//        String sql = "select * from users where username='" + user + "' and password='" + pass + "'";
        String sql = "select * from users where username = ? and password = ?";

        connection = config.Connection();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, pass);
        resultSet = preparedStatement.executeQuery();
//        statement = connection.createStatement();
//        resultSet = statement.executeQuery(sql);
        resultSet.next();
        status = resultSet.getInt("status");
        return status;
    }

}
