package org.example;

import DAO.daoUsuarios.daoUsuario;
import Model.usuario;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {

        usuario usu = daoUsuario.getInstance().retornaUsuario("CAJERO_1","cajero_1");
        System.out.println(usu.toString());
        // TEST URANUS19
    }
}