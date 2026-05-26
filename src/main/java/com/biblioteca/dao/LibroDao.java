package com.biblioteca.dao;

import com.biblioteca.model.Libro;
import java.util.List;

public interface LibroDao {
    void insertar(Libro libro);
    Libro buscarPorId(int id);
    List<Libro> obtenerTodos();
    void actualizar(Libro libro);
    void eliminar(int id);
}
