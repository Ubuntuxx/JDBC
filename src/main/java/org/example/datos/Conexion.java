package org.example.datos;

import java.sql.*;

public class Conexion {
    private static final String JDBCURL = "jdbc:mariadb://localhost:3306/springboot";
    private static final String JDBC_USER = "pepe";
    private static final String JDBC_PASS = "luis";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBCURL, JDBC_USER, JDBC_PASS);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection con) throws SQLException {
        con.close();
    }

}
