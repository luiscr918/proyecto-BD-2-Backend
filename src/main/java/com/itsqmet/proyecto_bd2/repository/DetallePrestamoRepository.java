package com.itsqmet.proyecto_bd2.repository;

import com.itsqmet.proyecto_bd2.model.DetallePrestamo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePrestamoRepository extends MongoRepository<DetallePrestamo, String> {
    List<DetallePrestamo> findByPrestamoId(String prestamoId);
    List<DetallePrestamo> findByVideojuegoId(String videojuegoId);
}
