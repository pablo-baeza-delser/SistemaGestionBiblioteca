package com.biblioteca.dao;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * private int id;
 * private String nombre;
 * private String email;
 */
public class UsuarioDaoImpl implements UsuarioDao {

    public void insertar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
        }
    }

    public Usuario buscarPorId(int id) {

        Usuario usuario = null;

        String sql = "SELECT * FROM usuarios " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));

            }
        } catch (SQLException e) {
            System.out.println("Error al encontrar el usuario buscado: " + e.getMessage());
        }
        return usuario;
    }

    public List<Usuario> obtenerTodos() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al devolver usuarios: " + e.getMessage());
        }

        return listaUsuarios;
    }

    public void actualizar(Usuario usuario) {
        String sql = "UPDATE usuarios " +
                "SET nombre = ?, email = ? " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setInt(3, usuario.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se ha podido actualizar el usuarios: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM usuarios " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}
