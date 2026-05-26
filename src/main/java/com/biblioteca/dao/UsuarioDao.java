package com.biblioteca.dao;

import com.biblioteca.model.Usuario;

import java.util.List;

public interface UsuarioDao {
    void insertar(Usuario usuario);

    Usuario buscarPorId(int id);

    List<Usuario> obtenerTodos();

    void actualizar(Usuario usuario);

    void eliminar(int id);
}