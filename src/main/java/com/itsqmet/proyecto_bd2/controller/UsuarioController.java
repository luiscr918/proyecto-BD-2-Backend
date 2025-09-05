package com.itsqmet.proyecto_bd2.controller;

import com.itsqmet.proyecto_bd2.model.Usuario;
import com.itsqmet.proyecto_bd2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Leer todos los usuarios
    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerTodos();
    }

    // Guardar nuevo usuario
    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    // Buscar usuario por ID
    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable String id) {
        return usuarioService.obtenerPorId(id);
    }

    // Actualizar usuario
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioService.obtenerPorId(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setApellido(usuario.getApellido());
            usuarioExistente.setCorreo(usuario.getCorreo());
            usuarioExistente.setTelefono(usuario.getTelefono());
            usuarioExistente.setContrasenia(usuario.getContrasenia());
            usuarioExistente.setRolId(usuario.getRolId());
            return usuarioService.guardar(usuarioExistente);
        }
        return null;
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable String id) {
        usuarioService.eliminar(id);
    }

    // Buscar usuarios por rol
    @GetMapping("/rol/{rolId}")
    public List<Usuario> obtenerUsuariosPorRol(@PathVariable String rolId) {
        return usuarioService.obtenerPorRol(rolId);
    }
}
