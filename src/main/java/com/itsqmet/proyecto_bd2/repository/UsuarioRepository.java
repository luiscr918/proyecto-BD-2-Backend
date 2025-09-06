package com.itsqmet.proyecto_bd2.repository;

import com.itsqmet.proyecto_bd2.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    List<Usuario> findByRolId(Integer rol_id);
    Optional<Usuario> findByCorreoAndContrasenia(String correo, String contrasenia);
}
