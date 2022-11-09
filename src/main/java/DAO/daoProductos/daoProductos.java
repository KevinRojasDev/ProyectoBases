package DAO.daoProductos;


import DAO.conexion;
import Model.producto;
import Model.usuario;

import java.sql.*;

public class daoProductos {
    private static daoProductos mInstance;

    public static daoProductos getInstance() {
        if (mInstance == null) {
            mInstance = new daoProductos();
        }
        return mInstance;
    }

//  Metodo de Insertar

    public void insertarProducto(producto prod, usuario user) {

        Connection con = null;
        try {

//            con = conexion.getConnection(user.getNombre(), user.getPassword());
            con = conexion.getConnectionDBA();
            CallableStatement statement = con.prepareCall("{call prc_inserta_producto(?,?,?,?,?,?,?)}");
            statement.setString("p_descripcion", prod.getDescripcion());
            statement.setFloat("p_peso", prod.getPeso());
            statement.setInt("p_cantidad", prod.getCantidad());
            statement.setFloat("p_precio", prod.getPrecio());
            statement.setString("p_plu", prod.getPlu());
            statement.setString("p_ean", prod.getEan());
            statement.setInt("p_id_categoria", prod.getId_Categoria());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//  Metodos de Actualizar

    public void actualizarProducto(producto prod, usuario user) {

        Connection con = null;
        try {

//            con = conexion.getConnection(user.getNombre(), user.getPassword());
            con = conexion.getConnectionDBA();
            CallableStatement statement = con.prepareCall("{call prc_actualizar_producto(?,?,?,?,?,?,?,?)}");
            statement.setInt("p_id", prod.getId());
            statement.setString("p_descripcion", prod.getDescripcion());
            statement.setFloat("p_peso", prod.getPeso());
            statement.setInt("p_cantidad", prod.getCantidad());
            statement.setFloat("p_precio", prod.getPrecio());
            statement.setString("p_plu", prod.getPlu());
            statement.setString("p_ean", prod.getEan());
            statement.setInt("p_id_categoria", prod.getId_Categoria());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProductoArea(producto prod, usuario user) {

        Connection con = null;
        try {

//            con = conexion.getConnection(user.getNombre(), user.getPassword());
            con = conexion.getConnectionDBA();
            CallableStatement statement = con.prepareCall("{call prc_actualizar_producto_area(?,?,?)}");
            statement.setInt("p_id", prod.getId());
            statement.setString("p_descripcion", prod.getDescripcion());
            statement.setInt("p_cantidad", prod.getCantidad());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProductoCantidad(producto prod, usuario user) {

        Connection con = null;
        try {

//            con = conexion.getConnection(user.getNombre(), user.getPassword());
            con = conexion.getConnectionDBA();
            CallableStatement statement = con.prepareCall("{call prc_actualizar_producto_cantidad(?,?)}");
            statement.setInt("p_id", prod.getId());
            statement.setInt("p_cantidad", prod.getCantidad());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//  Metodos de Busqueda

    public producto busquedaProductoCodigo(int codigo, usuario user) {

        producto producto = null;

        Connection con, con2 = null;
        try {

//            con = conexion.getConnection(email, contrasena);
//            con.close();
            con2 = conexion.getConnectionDBA();
            PreparedStatement statement = con2.prepareStatement("SELECT * FROM producto where id = " + codigo);
            statement.execute();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                producto = new producto(rs.getInt("id"), rs.getString("descripcion"), rs.getFloat("peso"),
                        rs.getInt("cantidad"), rs.getFloat("precio"), rs.getString("plu"), rs.getString("ean"),
                rs.getInt("id_Categoria"));
            }

            con2.close();

        } catch (SQLException e) {

        }
        return producto;
    }

    public producto busquedaProductoNombre(String descripcion, usuario user) {

        producto producto = null;

        Connection con, con2 = null;
        try {

//            con = conexion.getConnection(email, contrasena);
//            con.close();
            con2 = conexion.getConnectionDBA();
            PreparedStatement statement = con2.prepareStatement("SELECT * FROM producto where descripcion = " + "'" + descripcion + "'");
            statement.execute();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                producto = new producto(rs.getInt("id"), rs.getString("descripcion"), rs.getFloat("peso"),
                        rs.getInt("cantidad"), rs.getFloat("precio"), rs.getString("plu"), rs.getString("ean"),
                        rs.getInt("id_Categoria"));
            }

            con2.close();

        } catch (SQLException e) {

        }
        return producto;
    }

// Metodo eliminar

    public void EliminarProducto(int codigo, usuario user) {

        Connection con, con2 = null;
        try {

//            con = conexion.getConnection(email, contrasena);
//            con.close();
            con2 = conexion.getConnectionDBA();
            CallableStatement statement = con2.prepareCall("{call prc_elimina_producto(?)}");
            statement.setInt("p_id", codigo);
            statement.execute();
            con2.close();

        } catch (SQLException e) {

        }
    }

}
