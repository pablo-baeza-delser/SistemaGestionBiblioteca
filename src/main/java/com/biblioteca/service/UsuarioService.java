package com.biblioteca.service;

import com.biblioteca.dao.UsuarioDaoImpl;
import com.biblioteca.model.Usuario;

import java.util.List;

public class UsuarioService {

    UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();

    public void agregarUsuario(Usuario usuario) {
        usuarioDao.insertar(usuario);
    }

    public Usuario buscarUsuario(int id) {
        return usuarioDao.buscarPorId(id);
    }

    public List<Usuario> obtenerTodos() {
        return usuarioDao.obtenerTodos();
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioDao.actualizar(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioDao.eliminar(id);
    }

}
