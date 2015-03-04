
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


//SE logro guardar en el control de versiones
/**
 *
 * @author ColsutecR
 */
public class ActualizarDB {

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
            sentencia = conexion.createStatement();

            JOptionPane.showMessageDialog(null, "Actualizar datos de un producto");

            String id = JOptionPane.showInputDialog("Escriba la ID del produco a modificar");
            String sql = "SELECT * FROM tiendaenlinea.producto WHERE idProducto='" + id + "';";
            //System.out.println(sql);
            rs = sentencia.executeQuery(sql);

            if (rs.next() == true) {
                rs.beforeFirst();
                while (rs.next() == true) {

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
                // Leyendo datos para un select en la base de datos 
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
                
                String sql2 = ("UPDATE `tiendaenlinea`.`producto`"
                        + "SET"
                        + "`nombre` = '" + b + "',"
                        + "`marca` = '" + c + "',"
                        + "`referencia` = '" + d + "',"
                        + "`descripcion` = '" + e + "',"
                        + "`material` = '" + f + "',"
                        + "`color` = '" + g + "',"
                        + "`cantidad` = " + h + ","
                        + "`activo` = " + i + ","
                        + "`precioUnitario` = " + j + ","
                        + "`descuento` = " + k + ","
                        + "`Categoria_idCategoria` = " + l + ","
                        + "`Catalogo_idCatalogo` = " + m 
                        + " WHERE `idProducto` ='"+ id +"';");
                System.out.println(sql2);
                sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
                int res = sentencia.executeUpdate(sql2);

                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Se actualizo");
                } else if (res >= 2) {
                    JOptionPane.showMessageDialog(null, "No Se acualizo");
                }


                  
            } else {
                JOptionPane.showMessageDialog(null, "El ID del producto no existe");
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
