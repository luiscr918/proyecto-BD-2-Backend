package com.itsqmet.proyecto_bd2.repository;

import com.itsqmet.proyecto_bd2.model.Videojuego;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideojuegoRepository extends MongoRepository<Videojuego, String> {
    List<Videojuego> findByGenero(String genero);
    List<Videojuego> findByPlataforma(String plataforma);
}