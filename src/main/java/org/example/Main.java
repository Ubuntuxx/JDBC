package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/springboot", "pepe", "luis");
            Statement instruction = conn.createStatement();
            String sql = "Select * from nombres";
            ResultSet resuktado = instruction.executeQuery(sql);
            while (resuktado.next()){
                System.out.println("Id: " + resuktado.getInt("id") + "\t\tnombre " + resuktado.getString("nombre") + "\t\tapellido " + resuktado.getString("apellido"));
            }
            resuktado.close();
            instruction.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace(System.out);
        }
    }
}