package com.itsqmet.proyecto_bd2.repository;

import com.itsqmet.proyecto_bd2.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    List<Usuario> findByRolId(String rol_id);
}
