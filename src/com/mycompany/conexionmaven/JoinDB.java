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
public class JoinDB {

    public static void main(String[] args) throws SQLException {

        java.sql.Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;
        ResultSet res = null;
        //Mysql
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost/tiendaenlinea";
            String usuario = "root";
            String password = "123456789";
            conexion = DriverManager.getConnection(servidor, usuario, password);
            System.out.println("Se conecto a mysql");
            sentencia = conexion.createStatement();

            JOptionPane.showMessageDialog(null, "Buscar un producto");

            String idF = JOptionPane.showInputDialog("Escriba la ID de la factura");
            //Para saber si el SQL si esta bien ejecutado
            String sql2 = ("SELECT producto.nombre, "
                    + "item.cantidad, item.costoUnitario, "
                    + "item.costoTotal "
                    + "FROM tiendaenlinea.factura factura, "
                    + "tiendaenlinea.pedido pedido, "
                    + "tiendaenlinea.item item, tiendaenlinea.producto "
                    + "WHERE factura.idFactura = pedido.Factura_idFactura and pedido.Factura_idFactura = item.Pedido_Factura_idFactura and "
                    + "item.Producto_idProducto = producto.idProducto and factura.idFactura = " + idF + ";");
//            System.out.println(sql2);
            res = sentencia.executeQuery(sql2);

            if (res != null) {
                while (res.next() == true) {
                    //Con nombre de la columna
                    System.out.println("Nombre del producto: " + res.getString("nombre"));
                    //Con numero de la columna
                    System.out.println("Cantidad: " + res.getString(2));
                    System.out.println("Precio Unitario: " + res.getString(3));
                    System.out.println("Precio Total: " + res.getString(4));
                    System.out.println("=========================================================");
                }
            } else {
                System.out.println("no hay datos");
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
