package org.example;

import DAO.daoDetalle.daoDetalle;
import DAO.daoFactura.daoFactura;
import DAO.daoProductos.daoProductos;
import DAO.daoUsuarios.daoUsuario;
import Model.detalle;
import Model.factura;
import Model.producto;
import Model.usuario;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {

        usuario usu = daoUsuario.getInstance().retornaUsuario("CAJERO_1","cajero_1");
//        System.out.println(usu.toString());
        producto pro = new producto(0,"MONDONGO", 1500.0F, 0, 2000.0F, "70001", "00987654358", 1);
//        producto pro2 = new producto(29, "QUESO", 1500.0F, 0, 2750.0F, "70001", "00987654358", 1);
//        producto pro3 = new producto(29, "QUESO TURRIALBA", 1500.0F, 0, 2750.0F, "70001", "00987654358", 1);
//        producto pro4 = new producto(1, "QUESO TURRIALBA", 1500.0F, 9, 2750.0F, "70001", "00987654358", 1);
//          daoProductos.getInstance().insertarProducto(pro, usu);
//        daoProductos.getInstance().actualizarProducto(pro2, usu);
//        daoProductos.getInstance().actualizarProductoArea(pro3, usu);
//        daoProductos.getInstance().actualizarProductoCantidad(pro4, usu);
//        producto pro5 =  daoProductos.getInstance().busquedaProductoCodigo(2, usu);
//        producto pro6 =  daoProductos.getInstance().busquedaProductoNombre("POLLO", usu);
//        daoProductos.getInstance().EliminarProducto(29, usu);
        factura fac = new factura(usu.getNombre(), 1, "22-01-2022", "16:00", 0, 0);
        daoFactura.getInstance().insertarFactura(fac, usu);
        factura fac2 = daoFactura.getInstance().busquedaFacturaCodigo(1, usu);
        detalle det = new detalle(0, 1, 1, 1);
        daoDetalle.getInstance().insertarDetalle(det, usu);
        detalle det2 = daoDetalle.getInstance().busquedaDetalleCodigo(1, usu);
        daoDetalle.getInstance().EliminarDetalle(1, usu);
        daoFactura.getInstance().EliminarFactura(1, usu);
    }
}