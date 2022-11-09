package DAO.daoFactura;


public class daoFactura {
    private static daoFactura mInstance;

    public static daoFactura getInstance() {
        if (mInstance == null) {
            mInstance = new daoFactura();
        }
        return mInstance;
    }

    //  Metodo de Insertar

    public void insertarFactura(factura factura, usuario user) {

        Connection con = null;
        try {

//            con = conexion.getConnection(user.getNombre(), user.getPassword());
            con = conexion.getConnectionDBA();
            CallableStatement statement = con.prepareCall("{call prc_inserta_factura(?,?,?,?,?,?)}");
            statement.setString("p_cajero",factura.getCajero());
            statement.setInt("p_caja", factura.getCaja());
            statement.setString("p_fecha", factura.getFecha());
            statement.setString("p_hora", factura.getHora());
            statement.setFloat("p_subtotal", factura.getSubtotal());
            statement.setFloat("p_total", factura.getTotal());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //  Metodos de Busqueda

    public factura busquedaFacturaCodigo(int codigo, usuario user) {

        factura factura = null;

        Connection con, con2 = null;
        try {

//            con = conexion.getConnection(email, contrasena);
//            con.close();
            con2 = conexion.getConnectionDBA();
            PreparedStatement statement = con2.prepareStatement("SELECT * FROM factura where id = " + codigo);
            statement.execute();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                factura = new factura(rs.getString("cajero"),rs.getInt("caja"),rs.getString("fecha"),rs.getString("hora"),
                                      rs.getFloat("subtotal"),rs.getFloat("total"));
            }

            con2.close();

        } catch (SQLException e) {

        }
        return factura;
    }

    // Metodo eliminar

    public void EliminarFactura(int codigo, usuario user) {

        Connection con, con2 = null;
        try {

//            con = conexion.getConnection(email, contrasena);
//            con.close();
            con2 = conexion.getConnectionDBA();
            CallableStatement statement = con2.prepareCall("{call prc_elimina_factura(?)}");
            statement.setInt("id_fact", codigo);
            statement.execute();
            con2.close();

        } catch (SQLException e) {

        }
    }

}
