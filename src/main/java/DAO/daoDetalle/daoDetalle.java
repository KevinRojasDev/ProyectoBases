package DAO.daoDetalle;

import DAO.conexion;
import Model.detalle;
import Model.usuario;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class daoDetalle {

    private static daoDetalle mInstance;

    public static daoDetalle getInstance() {
        if (mInstance == null) {
            mInstance = new daoDetalle();
        }
        return mInstance;
    }

    //  Metodo de Insertar

    public void insertarDetalle(detalle det, usuario user) {

        Connection con = null;
        try {

//            con = conexion.getConnection(user.getNombre(), user.getPassword());
            con = conexion.getConnectionDBA();
            CallableStatement statement = con.prepareCall("{call prc_inserta_detalle_factura(?,?,?)}");
            statement.setInt("p_cantidad", det.getCantidad());
            statement.setInt("p_id_producto", det.getId_Producto());
            statement.setInt("p_id_factura", det.getId_Factura());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //  Metodos de Busqueda

    public detalle busquedaDetalleCodigo(int codigo, usuario user) {

        detalle detalle = null;

        Connection con, con2 = null;
        try {

//            con = conexion.getConnection(email, contrasena);
//            con.close();
            con2 = conexion.getConnectionDBA();
            CallableStatement statement = con2.prepareCall("{call prc_muestra_detalle(?,?)}");
            statement.setInt(1, codigo);
            statement.registerOutParameter(2, OracleTypes.CURSOR);
            statement.execute();
            ResultSet rs = (ResultSet) statement.getObject(2);
            while (rs.next()) {
                detalle = new detalle(rs.getInt("id"), rs.getInt("cantidad"), rs.getInt("id_Producto"), rs.getInt("id_Factura"));
            }

            con2.close();

        } catch (SQLException e) {

        }
        return detalle;
    }



// Metodo eliminar

    public void EliminarDetalle(int codigo, usuario user) {

        Connection con, con2 = null;
        try {

//            con = conexion.getConnection(email, contrasena);
//            con.close();
            con2 = conexion.getConnectionDBA();
            CallableStatement statement = con2.prepareCall("{call prc_elimina_detalle(?)}");
            statement.setInt("p_id", codigo);
            statement.execute();
            con2.close();

        } catch (SQLException e) {

        }
    }



}
