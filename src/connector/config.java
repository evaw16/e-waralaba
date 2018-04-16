/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connector;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Brian R
 */
public class config {

    public static Connection connection;

    public static Connection Connection() {

        try {
            String username = "root";
            String password = "";
            String database = "e-waralaba";
            String url = "jdbc:mysql://localhost/" + database;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public static void main(String[] args) {
        System.out.println(config.Connection());
    }
}
