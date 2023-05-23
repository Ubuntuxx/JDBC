package org.example.datos;

import org.example.domain.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    private static final String SQL_SELECT = "select id_persona, nombre, apellido, email, telefono from persona";
    private static final String SQL_INSERT = "insert into persona (nombre, apellido, email, telefono) values (?,?,?,?)";
    private static final String SQL_DELETE = "delete from persona where id_persona = ?";
    private static final String SQL_UPDATE = "update persona set nombre = ?, apellido = ?, email= ?, telefono = ? where id_persona = ?";


    public List<Persona> seleccionar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(con);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return personas;
    }

    public int borrar(Persona persona) {
        int registros = 0;
        Connection conn = null;
        PreparedStatement stms = null;
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_DELETE);
            stms.setInt(1, persona.getIdPersona());
            registros = stms.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                conn.close();
                stms.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registros;
    }

    public int editar(Persona persona) {
        Connection con = null;
        PreparedStatement stms = null;
        int registro = 0;
        try {
            con = Conexion.getConnection();
            stms = con.prepareStatement(SQL_UPDATE);
            stms.setString(1, persona.getNombre());
            stms.setString(2, persona.getApellido());
            stms.setString(3, persona.getEmail());
            stms.setString(4, persona.getTelefono());
            stms.setInt(5, persona.getIdPersona());
            registro = stms.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(stms);
                Conexion.close(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registro;
    }

    public int insertar(Persona persona) {
        Connection conn = null;
        PreparedStatement stms = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stms = conn.prepareStatement(SQL_INSERT);
            stms.setString(1, persona.getNombre());
            stms.setString(2, persona.getApellido());
            stms.setString(3, persona.getEmail());
            stms.setString(4, persona.getTelefono());
            registros = stms.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(stms);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return registros;

    }
}
