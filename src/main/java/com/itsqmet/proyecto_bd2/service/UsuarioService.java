package com.itsqmet.proyecto_bd2.service;

import com.itsqmet.proyecto_bd2.model.Usuario;
import com.itsqmet.proyecto_bd2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerPorId(String id) {
        return usuarioRepository.findById(id);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminar(String id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> obtenerPorRol(Integer rolId) {
        return usuarioRepository.findByRolId(rolId);
    }
    /* Nuevo metodo para login*/
    public Optional<Usuario> login(String correo, String contrasenia) {
        return usuarioRepository.findByCorreoAndContrasenia(correo, contrasenia);
    }
}
