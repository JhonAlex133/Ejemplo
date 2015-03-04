/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conexionmaven;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;

/**
 *
 * @author ColsutecR
 */
public class EjemploConexion5 {

    public static void main(String[] args) throws SQLException {
        java.sql.Connection conexion = null;

        //Mysql
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://172.16.4.142/pijamax";
            String usuario = "nicolas";
            String password = "12345";
            conexion = DriverManager.getConnection(servidor, usuario, password);
            System.out.println("Se conecto a mysql");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.toString());
        } finally {
            if (conexion != null) {
                conexion.close();
                System.out.println("Se cerro la conexion corectamente");
            }
        }

        //Oracle
        java.sql.Connection conexion2 = null;

        try {

            String servidor = "jdbc:oracle:thin:@172.16.4.142:1521/XE";
            String usuario = "SENA";
            String password = "Sena2014";
            conexion2 = DriverManager.getConnection(servidor, usuario, password);
            System.out.println("Se conecto a oracle");
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            if (conexion2 != null) {
                conexion2.close();
                System.out.println("Se cerro la conexion corectamente");
            }
        }
        
        //PostgreSQL
        
        java.sql.Connection conexion3 = null;
        
        try {

            String servidor = "jdbc:postgresql://localhost:5432/Ejemplo";
            String usuario = "postgres";
            String password = "123456789";
        conexion3 = DriverManager.getConnection(servidor, usuario, password);
            System.out.println("Se conecto a postgreSQL");
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            if (conexion3 != null) {
                conexion3.close();
                System.out.println("Se cerro la conexion corectamente");
            }
        }
        
    }

}
