package com.itsqmet.proyecto_bd2.controller;

import com.itsqmet.proyecto_bd2.model.Videojuego;
import com.itsqmet.proyecto_bd2.service.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videojuegos")
@CrossOrigin(origins = "http://localhost:5173")
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;

    // Leer todos los videojuegos
    @GetMapping
    public List<Videojuego> mostrarVideojuegos() {
        return videojuegoService.obtenerTodos();
    }

    // Guardar nuevo videojuego
    @PostMapping
    public Videojuego guardarVideojuego(@RequestBody Videojuego videojuego) {
        return videojuegoService.guardar(videojuego);
    }

    // Buscar videojuego por ID
    @GetMapping("/{id}")
    public Optional<Videojuego> buscarVideojuegoId(@PathVariable String id) {
        return videojuegoService.obtenerPorId(id);
    }

    // Actualizar videojuego
    @PutMapping("/{id}")
    public Videojuego actualizarVideojuego(@PathVariable String id, @RequestBody Videojuego videojuego) {
        Optional<Videojuego> videojuegoOptional = videojuegoService.obtenerPorId(id);
        if (videojuegoOptional.isPresent()) {
            Videojuego existente = videojuegoOptional.get();
            existente.setTitulo(videojuego.getTitulo());
            existente.setGenero(videojuego.getGenero());
            existente.setStock(videojuego.getStock());
            existente.setPlataforma(videojuego.getPlataforma());
            existente.setPrecio(videojuego.getPrecio());
            return videojuegoService.guardar(existente);
        }
        return null;
    }

    // Eliminar videojuego
    @DeleteMapping("/{id}")
    public void eliminarVideojuego(@PathVariable String id) {
        videojuegoService.eliminar(id);
    }

    // Buscar por género
    @GetMapping("/genero/{genero}")
    public List<Videojuego> obtenerPorGenero(@PathVariable String genero) {
        return videojuegoService.obtenerPorGenero(genero);
    }

    // Buscar por plataforma
    @GetMapping("/plataforma/{plataforma}")
    public List<Videojuego> obtenerPorPlataforma(@PathVariable String plataforma) {
        return videojuegoService.obtenerPorPlataforma(plataforma);
    }
}
