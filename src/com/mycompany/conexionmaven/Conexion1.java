/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conexionmaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ColsutecR
 */
public class Conexion1 {

    public static void main(String[] args) throws SQLException {
        Connection con = null;
        try {
            DriverManager.getConnection("jdbc:mysql://localhost/akuavida?"
                    + "user=root&password=123456789");
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
