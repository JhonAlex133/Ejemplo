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
public class InsertDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        java.sql.Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;
        //Mysql
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost/tiendaenlinea";
            String usuario = "root";
            String password = "123456789";
            conexion = DriverManager.getConnection(servidor, usuario, password);
            System.out.println("Se conecto a mysql");
            
            JOptionPane.showMessageDialog(null, "Agregar un producto");
            
            // Leyendo datos para un select en la base de datos 
            String a = JOptionPane.showInputDialog("Escriba el ID del producto");
            String b = JOptionPane.showInputDialog("Escriba el nombre del producto");
            String c = JOptionPane.showInputDialog("Escriba la marca del producto");
            String d = JOptionPane.showInputDialog("Escriba la referencia del producto");
            String e = JOptionPane.showInputDialog("Escriba la descripcion del producto");
            String f = JOptionPane.showInputDialog("Escriba el material del producto");
            String g = JOptionPane.showInputDialog("Escriba el color del producto");
            String h = JOptionPane.showInputDialog("Escriba la cantidad del producto");
            String i = JOptionPane.showInputDialog("Escriba el estado del producto del producto");
            String j = JOptionPane.showInputDialog("Escriba el precio unitario del producto");
            String k = JOptionPane.showInputDialog("Escriba el descuento del producto");
            String l = JOptionPane.showInputDialog("Escriba la categoria del producto");
            String m = JOptionPane.showInputDialog("Escriba el catalogo del producto");

            //Para saber si el SQL si esta bien ejecutado
            //System.out.println(sql);
            String sql = ("INSERT INTO tiendaenlinea.producto"
                    + "(idProducto,"
                    + "nombre,"
                    + "marca,"
                    + "referencia,"
                    + "descripcion,"
                    + "material,"
                    + "color,"
                    + "cantidad,"
                    + "activo,"
                    + "precioUnitario,"
                    + "descuento,"
                    + "Categoria_idCategoria,"
                    + "Catalogo_idCatalogo)"
                    + "VALUES"
                    + "('" + a + "',"
                    + "'" + b + "',"
                    + "'" + c + "',"
                    + "'" + d + "',"
                    + "'" + e + "',"
                    + "'" + f + "',"
                    + "'" + g + "',"
                    + h + ","
                    + i + ","
                    + j + ","
                    + k + ","
                    + l + ","
                    + m + ");");
            
            sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            int res = sentencia.executeUpdate(sql);

            if (res == 1) {
                System.out.println("Se Inserto");
            }else if(res >= 2){
                System.out.println("No se inserto");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.toString());
        } finally {
            if (conexion != null) {
                conexion.close();
                System.out.println("Se cerro la conexion corectamente");
            }
        }

    }

}
