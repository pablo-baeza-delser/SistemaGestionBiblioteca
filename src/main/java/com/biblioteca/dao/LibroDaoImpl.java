package com.biblioteca.dao;

import com.biblioteca.model.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDaoImpl implements LibroDao {

    public void insertar(Libro libro) {
        String sql = "INSERT INTO libros (titulo, autor, genero, disponible) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getGenero());
            ps.setBoolean(4, libro.isDisponible());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar libro: " + e.getMessage());
        }
    }

    public Libro buscarPorId(int id) {

        Libro libro = null;

        String sql = "SELECT * FROM libros " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                libro = new Libro();
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setGenero(rs.getString("genero"));
                libro.setDisponible(rs.getBoolean("disponible"));
                libro.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println("Error al encontrar el libro buscado: " + e.getMessage());
        }
        return libro;

    }


    public List<Libro> obtenerTodos() {
        List<Libro> listaLibros = new ArrayList<>();
        String sql = "SELECT * FROM libros";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setGenero(rs.getString("genero"));
                libro.setDisponible(rs.getBoolean("disponible"));
                libro.setId(rs.getInt("id"));
                listaLibros.add(libro);
            }
        } catch (SQLException e) {
            System.out.println("Error al devolver libros: " + e.getMessage());
        }

        return listaLibros;
    }


    public void actualizar(Libro libro) {
        String sql = "UPDATE libros " +
                "SET titulo = ?, autor = ?, genero = ?, disponible = ? " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getGenero());
            ps.setBoolean(4, libro.isDisponible());
            ps.setInt(5, libro.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se ha podido actualizar el libro: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM libros " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar libro: " + e.getMessage());
        }
    }
}
