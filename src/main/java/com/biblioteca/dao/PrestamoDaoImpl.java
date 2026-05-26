package com.biblioteca.dao;

import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDaoImpl implements PrestamoDao {

    public void insertar(Prestamo prestamo) {
        String sql = "INSERT INTO prestamos (id_libro, id_usuario, fecha_prestamo, fecha_devolucion) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, prestamo.getLibro().getId());
            ps.setInt(2, prestamo.getUsuario().getId());
            ps.setString(3, prestamo.getFechaPrestamo());
            ps.setString(4, prestamo.getFechaDevolucion());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar el prestamo: " + e.getMessage());
        }
    }

    public Prestamo buscarPorId(int id) {

        Prestamo prestamo = null;

        String sql = "SELECT * FROM prestamos " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                prestamo = new Prestamo();
                prestamo.setId(rs.getInt("id"));

                LibroDaoImpl libroDao = new LibroDaoImpl();
                prestamo.setLibro(libroDao.buscarPorId(rs.getInt("id_libro")));

                UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
                prestamo.setUsuario(usuarioDao.buscarPorId(rs.getInt("id_usuario")));

                prestamo.setFechaPrestamo(rs.getString("fecha_prestamo"));
                prestamo.setFechaDevolucion(rs.getString("fecha_devolucion"));

            }
        } catch (SQLException e) {
            System.out.println("Error al encontrar el préstamo buscado: " + e.getMessage());
        }
        return prestamo;
    }

    public List<Prestamo> obtenerTodos() {
        List<Prestamo> listaPrestamo = new ArrayList<>();
        String sql = "SELECT * FROM prestamos";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prestamo prestamo = new Prestamo();
                prestamo.setId(rs.getInt("id"));

                LibroDaoImpl libroDao = new LibroDaoImpl();
                prestamo.setLibro(libroDao.buscarPorId(rs.getInt("id_libro")));

                UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
                prestamo.setUsuario(usuarioDao.buscarPorId(rs.getInt("id_usuario")));

                prestamo.setFechaPrestamo(rs.getString("fecha_prestamo"));
                prestamo.setFechaDevolucion(rs.getString("fecha_devolucion"));
                listaPrestamo.add(prestamo);
            }
        } catch (SQLException e) {
            System.out.println("Error al devolver prestamos: " + e.getMessage());
        }

        return listaPrestamo;
    }

    public List<Prestamo> obtenerPrestamosActivos() {
        List<Prestamo> listaPrestamo = new ArrayList<>();
        String sql = "SELECT * FROM prestamos " +
                "WHERE fecha_devolucion IS NULL";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prestamo prestamo = new Prestamo();
                prestamo.setId(rs.getInt("id"));

                LibroDaoImpl libroDao = new LibroDaoImpl();
                prestamo.setLibro(libroDao.buscarPorId(rs.getInt("id_libro")));

                UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
                prestamo.setUsuario(usuarioDao.buscarPorId(rs.getInt("id_usuario")));

                prestamo.setFechaPrestamo(rs.getString("fecha_prestamo"));
                prestamo.setFechaDevolucion(rs.getString("fecha_devolucion"));
                listaPrestamo.add(prestamo);
            }

        } catch (SQLException e) {
            System.out.println("Error al devolver prestamos: " + e.getMessage());
        }

        return listaPrestamo;
    }


    public void actualizar(Prestamo prestamo) {
        String sql = "UPDATE prestamos " +
                "SET id_libro = ?, id_usuario = ?, fecha_prestamo = ?, fecha_devolucion = ? " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, prestamo.getLibro().getId());
            ps.setInt(2, prestamo.getUsuario().getId());
            ps.setString(3, prestamo.getFechaPrestamo());
            ps.setString(4, prestamo.getFechaDevolucion());
            ps.setInt(5, prestamo.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se ha podido actualizar el préstamo: " + e.getMessage());
        }
    }

    /**
     * private int id;
     * private Libro libro;
     * private Usuario usuario;
     * private String fechaPrestamo;
     * private String fechaDevolucion;
     */
    public void eliminar(int id) {
        String sql = "DELETE FROM prestamos " +
                "WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el préstamo: " + e.getMessage());
        }
    }
}
