package DAO.daoUsuarios;

import Model.usuario;
import DAO.conexion;

import java.sql.*;

public class daoUsuario {

    private static daoUsuario mInstance;

    public static daoUsuario getInstance() {
        if (mInstance == null) {
            mInstance = new daoUsuario();
        }
        return mInstance;
    }

    public usuario retornaUsuario(String email, String contrasena) {

        usuario usuario = null;

        Connection con, con2 = null;
        try {

            con = conexion.getConnection(email, contrasena);
            con.close();
            con2 = conexion.getConnectionDBA();
            PreparedStatement statement = con2.prepareStatement("select * from dba_role_privs where grantee = " + "'" + email + "'");
            statement.execute();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                usuario = new usuario(email, contrasena, "");
                usuario.setRole(rs.getString("GRANTED_ROLE"));
            }

            con2.close();

        } catch (SQLException e) {

        }
        return usuario;
    }
};
