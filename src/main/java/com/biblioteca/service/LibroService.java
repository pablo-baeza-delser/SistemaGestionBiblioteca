package com.biblioteca.service;

import com.biblioteca.dao.LibroDaoImpl;
import com.biblioteca.model.Libro;

import java.util.ArrayList;
import java.util.List;

public class LibroService {

    private LibroDaoImpl libroDao = new LibroDaoImpl();

    public void agregarLibro(Libro libro) {
        libroDao.insertar(libro);
    }

    public Libro buscarLibro(int id) {
        return libroDao.buscarPorId(id);
    }

    public List<Libro> obtenerTodos() {
        return libroDao.obtenerTodos();
    }

    public void actualizarLibro(Libro libro) {
        libroDao.actualizar(libro);
    }

    public void eliminarLibro(int id) {
        libroDao.eliminar(id);
    }

    public void prestarLibro(int id) {
        Libro libro = libroDao.buscarPorId(id);
        if (!libro.isDisponible()) {
            throw new IllegalStateException("El libro no está disponible.");
        }
        libro.setDisponible(false);
        libroDao.actualizar(libro);
    }

    public void devolverLibro(int id) {
        Libro libro = libroDao.buscarPorId(id);
        if (libro.isDisponible()) {
            throw new IllegalStateException("El libro no se puede devolver porque no se había prestado.");
        }
        libro.setDisponible(true);
        libroDao.actualizar(libro);
    }
}
