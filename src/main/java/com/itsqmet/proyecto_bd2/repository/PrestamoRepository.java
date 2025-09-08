package com.itsqmet.proyecto_bd2.repository;

import com.itsqmet.proyecto_bd2.model.Prestamo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends MongoRepository<Prestamo, String> {
    List<Prestamo> findByUsuarioId(String usuarioId);
    List<Prestamo> findByEstado(String estado);
    List<Prestamo> findByVideojuegoId(String videojuegoId);
}
