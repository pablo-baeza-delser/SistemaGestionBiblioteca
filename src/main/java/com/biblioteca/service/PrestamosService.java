package com.biblioteca.service;

import com.biblioteca.dao.PrestamoDaoImpl;
import com.biblioteca.model.Prestamo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class PrestamosService {

    private PrestamoDaoImpl prestamoDao = new PrestamoDaoImpl();

    public void registrarPrestamo(Prestamo prestamo) {
        prestamoDao.insertar(prestamo);
    }

    public Prestamo buscarPrestamo(int id) {
        return prestamoDao.buscarPorId(id);
    }

    public List<Prestamo> obtenerTodos() {
        return prestamoDao.obtenerTodos();
    }

    public List<Prestamo> obtenerPrestamosActivo() {
        return prestamoDao.obtenerPrestamosActivos();
    }

    public void registrarDevolucion(int id) {
        Prestamo prestamo = prestamoDao.buscarPorId(id);

        if (prestamo.getFechaDevolucion() != null) {
            throw new IllegalStateException("Este préstamo ya fue devuelto.");
        }

        String fechaHoy = LocalDate.now().toString();
        prestamo.setFechaDevolucion(fechaHoy);
        prestamoDao.actualizar(prestamo);
    }

    public void eliminarPrestamo(int id) {
        prestamoDao.eliminar(id);
    }
}
