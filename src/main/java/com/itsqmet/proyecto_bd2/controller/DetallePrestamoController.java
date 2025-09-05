package com.itsqmet.proyecto_bd2.controller;

import com.itsqmet.proyecto_bd2.model.DetallePrestamo;
import com.itsqmet.proyecto_bd2.service.DetallePrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle-prestamo")
@CrossOrigin(origins = "http://localhost:5173")
public class DetallePrestamoController {

    @Autowired
    private DetallePrestamoService detallePrestamoService;

    @GetMapping
    public List<DetallePrestamo> mostrarDetallePrestamos() {
        return detallePrestamoService.obtenerTodos();
    }

    @PostMapping
    public DetallePrestamo guardarDetallePrestamo(@RequestBody DetallePrestamo detallePrestamo) {
        return detallePrestamoService.guardar(detallePrestamo);
    }

    @GetMapping("/{id}")
    public Optional<DetallePrestamo> buscarDetallePrestamoId(@PathVariable String id) {
        return detallePrestamoService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public DetallePrestamo actualizarDetallePrestamo(@PathVariable String id, @RequestBody DetallePrestamo detallePrestamo) {
        Optional<DetallePrestamo> existente = detallePrestamoService.obtenerPorId(id);
        if (existente.isPresent()) {
            DetallePrestamo actual = existente.get();
            actual.setCantidad(detallePrestamo.getCantidad());
            actual.setSubtotal(detallePrestamo.getSubtotal());
            actual.setTotal(detallePrestamo.getTotal());
            actual.setPrestamoId(detallePrestamo.getPrestamoId());
            actual.setVideojuegoId(detallePrestamo.getVideojuegoId());
            return detallePrestamoService.guardar(actual);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarDetallePrestamo(@PathVariable String id) {
        detallePrestamoService.eliminar(id);
    }


}
