package com.itsqmet.proyecto_bd2.controller;

import com.itsqmet.proyecto_bd2.entity.Videojuego;
import com.itsqmet.proyecto_bd2.service.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videojuego")
/*@CrossOrigin(origins = "http://localhost:4200")*/
public class VideojuegoController {
    @Autowired
    private VideojuegoService videojuegoService;
    //leer todos los videojuegos
    @GetMapping
    public List<Videojuego> mostrarVideojuegos() {
        return videojuegoService.allVideojuegos();
    }

    //guardar nuevo videojuego
    @PostMapping
    public Videojuego guardarVideojuego(@RequestBody Videojuego videojuego) {
        return videojuegoService.guardarVideojuego(videojuego);
    }
    //Buscar Videojuego por id
    @GetMapping("/{id}")
    public Optional<Videojuego> buscarVideojuegoId(@PathVariable Long id){
        return videojuegoService.buscarVideojuegoId(id);
    }
    //actualizar videojuego
    @PutMapping("/{id}")
    public Videojuego actualizarVideojuego(@PathVariable Long id, @RequestBody Videojuego videojuego) {
        Optional<Videojuego> videojuegoOptional = videojuegoService.buscarVideojuegoId(id);
        if (videojuegoOptional.isPresent()) {
            Videojuego VideojuegoExistente = videojuegoOptional.get();
            VideojuegoExistente.setTitulo(videojuego.getTitulo());
            VideojuegoExistente.setGenero(videojuego.getGenero());
            VideojuegoExistente.setStock(videojuego.getStock());
            VideojuegoExistente.setPlataforma(videojuego.getPlataforma());
            VideojuegoExistente.setPrecio(videojuego.getPrecio());
            VideojuegoExistente.setDetallePrestamo(videojuego.getDetallePrestamo());
            return videojuegoService.guardarVideojuego(VideojuegoExistente);
        }
        return null;
    }

    //eliminar videojuego
    @DeleteMapping("/{id}")
    public void eliminarVideojuego(@PathVariable Long id) {
        videojuegoService.eliminarVideojuego(id);
    }
}
