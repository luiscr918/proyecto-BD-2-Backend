package com.itsqmet.proyecto_bd2.service;

import com.itsqmet.proyecto_bd2.entity.Videojuego;
import com.itsqmet.proyecto_bd2.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideojuegoService {
    @Autowired
    private VideojuegoRepository videojuegoRepository;
    //Lista de videojuegos
    public List<Videojuego> allVideojuegos(){
        return videojuegoRepository.findAll();
    }

    //buscar por id(para actualizar y eliminar)
    public Optional<Videojuego> buscarVideojuegoId(Long id){
        return videojuegoRepository.findById(id);
    }
    //Guardar videojuego
    public Videojuego guardarVideojuego(Videojuego videojuego){
        return videojuegoRepository.save(videojuego);
    }
    //Eliminar videojuego
    public void eliminarVideojuego(Long id){
        videojuegoRepository.deleteById(id);
    }
}
