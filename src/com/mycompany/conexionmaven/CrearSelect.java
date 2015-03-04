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
 * @author My PC
 */
public class CrearSelect {

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
            String a = JOptionPane.showInputDialog("Escriba una palabra");
            String sql = "SELECT * FROM tiendaenlinea.producto "
                    + "WHERE nombre like '%" +a+"%'";
            System.out.println(sql);
            rs = sentencia.executeQuery(sql);

            //Mostrar en pantalla la informacion de la tabla del RESULTSET
            if (!rs.wasNull()) {
                while (rs.next() == true) {
                    //Con nombre de la columna
                    System.out.println("ID producto: " + rs.getString("idProducto"));
                    System.out.println("Nombre del producto: " + rs.getString("nombre"));
                    //Con numero de la columna
                    System.out.println("Marca: " + rs.getString(3));
                    System.out.println("Referencia: " + rs.getString(4));
                    System.out.println("Descripción: " + rs.getString(5));
                    System.out.println("Material: " + rs.getString(6));
                    System.out.println("Color: " + rs.getString(7));
                    System.out.println("Foto: " + rs.getString(8));
                    System.out.println("Cantidad: " + rs.getString(9));
                    System.out.println("Activo: " + rs.getString(10));
                    System.out.println("Precio Unitario: " + rs.getString(11));
                    System.out.println("Descuento: " + rs.getString(12));
                    System.out.println("Categoria: " + rs.getString(13));
                    System.out.println("Catalogo: " + rs.getString(14));
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
