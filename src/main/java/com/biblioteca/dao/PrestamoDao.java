package com.biblioteca.dao;

import com.biblioteca.model.Prestamo;

import java.util.List;

public interface PrestamoDao {
    void insertar(Prestamo prestamo);

    Prestamo buscarPorId(int id);

    List<Prestamo> obtenerTodos();

    List<Prestamo> obtenerPrestamosActivos();

    void actualizar(Prestamo prestamo);

    void eliminar(int id);
}
