/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pboproject;

import controller.c_login;
import java.sql.SQLException;
import model.m_login;
import view.Login;

/**
 *
 * @author Brian R
 */
public class PBOProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        m_login m = new m_login();
        Login v = new Login();
        c_login c = new c_login(m,v);
        
    }
    
}
