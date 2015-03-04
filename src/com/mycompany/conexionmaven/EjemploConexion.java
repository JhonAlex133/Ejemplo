/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conexionmaven;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ColsutecR
 */
public class EjemploConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        java.sql.Connection conexion = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://172.16.4.142/pijamax";
            String usuario = "nicolas";
            String password = "12345";
            conexion = DriverManager.getConnection(servidor, usuario, password);
            System.out.println("Se conecto");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.toString());
        }finally{
            if (conexion != null) {
                conexion.close();
                System.out.println("Se cerro la conexion corectamente");
            }
        }
    }
    
}
