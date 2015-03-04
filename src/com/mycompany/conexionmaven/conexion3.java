/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conexionmaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author ColsutecR
 */
public class conexion3 {

    public static void main(String[] args) throws SQLException {
        Connection con = null;
        Properties propie = new Properties();
        propie.setProperty("user", "root");
        propie.setProperty("password", "123456789");

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/akuavida?", propie);
            System.out.println("Se conecto");
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (con != null) {
                con.close();
                System.out.println("Se cerro la conexion corectamente");
            }
        }
    }
}
