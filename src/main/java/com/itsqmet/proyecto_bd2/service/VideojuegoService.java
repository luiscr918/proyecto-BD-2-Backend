package com.itsqmet.proyecto_bd2.service;

import com.itsqmet.proyecto_bd2.model.Videojuego;
import com.itsqmet.proyecto_bd2.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideojuegoService {
    @Autowired
    private VideojuegoRepository videojuegoRepository;

    public List<Videojuego> obtenerTodos() {
        return videojuegoRepository.findAll();
    }

    public Optional<Videojuego> obtenerPorId(String id) {
        return videojuegoRepository.findById(id);
    }

    public Videojuego guardar(Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    public void eliminar(String id) {
        videojuegoRepository.deleteById(id);
    }

    public List<Videojuego> obtenerPorGenero(String genero) {
        return videojuegoRepository.findByGenero(genero);
    }
    public List<Videojuego> obtenerPorPlataforma(String plataforma) {
        return videojuegoRepository.findByPlataforma(plataforma);
    }
}
