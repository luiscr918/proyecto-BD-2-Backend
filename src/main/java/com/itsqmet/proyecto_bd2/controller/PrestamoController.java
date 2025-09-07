package com.itsqmet.proyecto_bd2.controller;

import com.itsqmet.proyecto_bd2.model.Prestamo;
import com.itsqmet.proyecto_bd2.repository.PrestamoRepository;
import com.itsqmet.proyecto_bd2.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/prestamo")
@CrossOrigin(origins = "http://localhost:5173")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;
    @Autowired
    private PrestamoRepository prestamoRepository;

    // Leer todos los préstamos
    @GetMapping
    public List<Prestamo> mostrarPrestamos() {
        return prestamoService.obtenerTodos();
    }

    // Guardar nuevo préstamo
    @PostMapping
    public Prestamo guardarPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoService.guardar(prestamo);
    }

    // Buscar préstamo por ID
    @GetMapping("/{id}")
    public Optional<Prestamo> buscarPrestamoId(@PathVariable String id) {
        return prestamoService.obtenerPorId(id);
    }

    // Actualizar préstamo
    @PutMapping("/{id}")
    public Prestamo actualizarPrestamo(@PathVariable String id, @RequestBody Prestamo prestamo) {
        Optional<Prestamo> prestamoOptional = prestamoService.obtenerPorId(id);
        if (prestamoOptional.isPresent()) {
            Prestamo prestamoExistente = prestamoOptional.get();
            prestamoExistente.setFechaPrestamo(prestamo.getFechaPrestamo());
            prestamoExistente.setFechaDevolucion(prestamo.getFechaDevolucion());
            prestamoExistente.setEstado(prestamo.getEstado());
            prestamoExistente.setCantidad(prestamo.getCantidad());
            prestamoExistente.setSubtotal(prestamo.getSubtotal());
            prestamoExistente.setTotal(prestamo.getTotal());
            prestamoExistente.setVideojuegoId(prestamo.getVideojuegoId());
            prestamoExistente.setUsuarioId(prestamo.getUsuarioId());
            return prestamoService.guardar(prestamoExistente);
        }
        return null;
    }

    // Eliminar préstamo
    @DeleteMapping("/{id}")
    public void eliminarPrestamo(@PathVariable String id) {
        prestamoService.eliminar(id);
    }

    // Buscar préstamos por usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<Prestamo> obtenerPorUsuario(@PathVariable String usuarioId) {
        return prestamoService.obtenerPorUsuario(usuarioId);
    }
    // Buscar préstamos por videojuego
    @GetMapping("/videojuego/{videojuegoId}")
    public List<Prestamo> obtenerPorVideojuego(@PathVariable String videojuegoId) {
        return prestamoService.obtenerPorVideojuego(videojuegoId);
    }

    // Buscar préstamos por estado
    @GetMapping("/estado/{estado}")
    public List<Prestamo> obtenerPorEstado(@PathVariable String estado) {
        return prestamoService.obtenerPorEstado(estado);
    }
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Prestamo> actualizarEstado(
            @PathVariable String id,
            @RequestBody Map<String, String> body) {

        String nuevoEstado = body.get("estado");
        return prestamoRepository.findById(id)
                .map(prestamo -> {
                    prestamo.setEstado(nuevoEstado);
                    Prestamo actualizado = prestamoRepository.save(prestamo);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }


}
