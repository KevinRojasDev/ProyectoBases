/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class conexion {

    private static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    //El puerto es opcional
    private static String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String JDBC_USER = "system";
    private static String JDBC_PASS = "system";
    private static Driver driver = null;

    public class Conexion {
        
    }
    
    public static Connection getConnection(String user, String password)
            throws SQLException {
        Connection c = null;
        driver = null;
        if (driver == null) {
            try {
                //Se registra el driver
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                c = DriverManager.getConnection(JDBC_URL, user, password);
            } catch (Exception e) {
                System.out.println("Fallo en cargar el driver JDBC");
                e.printStackTrace();
            }
        }
        return c;
    }

    public static Connection getConnectionDBA()
            throws SQLException {
        Connection c = null;
        driver = null;
        if (driver == null) {
            try {
                //Se registra el driver
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                c = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            } catch (Exception e) {
                System.out.println("Fallo en cargar el driver JDBC");
                e.printStackTrace();
            }
        }
        return c;
    }
    

    
}
