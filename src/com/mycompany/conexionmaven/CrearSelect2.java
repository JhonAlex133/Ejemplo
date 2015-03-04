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
import javax.swing.JOptionPane;

/**
 *
 * @author ColsutecR
 */
public class CrearSelect2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        java.sql.Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
//            String servidor = "jdbc:mysql://172.16.4.142/pijamax";
            String servidor = "jdbc:mysql://localhost/tiendaenlinea";
            String usuario = "root";
            String password = "123456789";
            conexion = DriverManager.getConnection(servidor, usuario, password);
            System.out.println("Se conecto a mysql");
            sentencia = conexion.createStatement();
            // Leyendo datos para un select en la base de datos 
            String a = JOptionPane.showInputDialog("Escriba el tipo de documento");
            String b = JOptionPane.showInputDialog("Escriba el numero de documento");
            
            String sql = "SELECT * FROM tiendaenlinea.cuenta "
                    + "WHERE tipoDocumento='" +a+"' and numeroDocumento=" + b ;
            
            //Para saber si el SQL si esta bien ejecutado
            //System.out.println(sql);
            
            rs = sentencia.executeQuery(sql);

            //Mostrar en pantalla la informacion de la tabla del RESULTSET
            if (!rs.wasNull()) {
                while (rs.next() == true) {
                    //Con nombre de la columna
                    System.out.println("tipo documento: " + rs.getString("tipoDocumento"));
                    System.out.println("Numero de documento: " + rs.getString("numeroDocumento"));
                    //Con numero de la columna
                    System.out.println("Primer Nombre: " + rs.getString(3));
                    System.out.println("Segundo Nombre: " + rs.getString(4));
                    System.out.println("Primer Apellido: " + rs.getString(5));
                    System.out.println("Segundo Apellido: " + rs.getString(6));
                    System.out.println("Contrasena: " + rs.getString(7));
                    System.out.println("Email: " + rs.getString(8));
                    System.out.println("Id usuario: " + rs.getString(9));
                    System.out.println("=========================================================");
                }
            } else {
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
