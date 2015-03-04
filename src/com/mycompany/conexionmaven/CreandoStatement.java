/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conexionmaven;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ColsutecR
 */
public class CreandoStatement {

    public static void main(String[] args) throws SQLException {

        java.sql.Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://172.16.4.142/pijamax";
            String usuario = "nicolas";
            String password = "12345";
            conexion = DriverManager.getConnection(servidor, usuario, password);
            System.out.println("Se conecto a mysql");
            sentencia = conexion.createStatement();
            int i = 100;
            rs = sentencia.executeQuery("SELECT * FROM pijamax.categorias" + i);

            //Mostrar en pantalla la informacion de la tabla del RESULTSET
            if (!rs.wasNull()) {
                while (rs.next() == true) {
                    //Con nombre de la columna
                    System.out.println("ID categoria: " + rs.getString("id_categoria"));
                    System.out.println("Nombre de la categoria: " + rs.getString("nombre_categoria"));
                    //Con numero de la columna
                    System.out.println("Activo: " + rs.getString(2));
                    System.out.println("=========================================================");
                }
            }else{
                System.out.println("no hay datos");
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.toString());
        } finally {
            //Cerrando el Statement 
            if (sentencia != null) {
                sentencia.close();
                System.out.println("Se cerro el Statement corectamente");
            }
            //Cerrar el ResultSet
            if (!rs.wasNull()) {
                rs.close();
                System.out.println("Se cerro el ResultSet corectamente");
            }
            //Cerrando la conexion
            if (conexion != null) {
                conexion.close();
                System.out.println("Se cerro la conexion corectamente");
            }
        }
    }
}
