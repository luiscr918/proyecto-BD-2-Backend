package com.itsqmet.proyecto_bd2.controller;

import com.itsqmet.proyecto_bd2.entity.DetallePrestamo;
import com.itsqmet.proyecto_bd2.service.DetallePrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle-prestamo")
/*@CrossOrigin(origins = "http://localhost:4200")*/
public class DetallePrestamoController {
    @Autowired
    private DetallePrestamoService detallePrestamoService;
    //leer todos los detalles de prestamo
    @GetMapping
    public List<DetallePrestamo> mostrarDetallePrestamos() {
        return detallePrestamoService.allDetallePrestamos();
    }

    //guardar nuevo detalle prestamo
    @PostMapping
    public DetallePrestamo guardarDetallePrestamo(@RequestBody DetallePrestamo detallePrestamo) {
        return detallePrestamoService.guardarDetallePrestamo(detallePrestamo);
    }
    //Buscar DetallePrestamo por id
    @GetMapping("/{id}")
    public Optional<DetallePrestamo> buscarDetallePrestamoId(@PathVariable Long id){
        return detallePrestamoService.buscarDetallePrestamoId(id);
    }
    //actualizar detallePrestamo
    @PutMapping("/{id}")
    public DetallePrestamo actualizarDetallePrestamo(@PathVariable Long id, @RequestBody DetallePrestamo detallePrestamo) {
        Optional<DetallePrestamo> detallePrestamoOptional = detallePrestamoService.buscarDetallePrestamoId(id);
        if (detallePrestamoOptional.isPresent()) {
            DetallePrestamo detallePrestamoExistente = detallePrestamoOptional.get();
            detallePrestamoExistente.setPrestamo(detallePrestamo.getPrestamo());
            detallePrestamoExistente.setCantidad(detallePrestamo.getCantidad());
            detallePrestamoExistente.setTotal(detallePrestamo.getTotal());
            detallePrestamoExistente.setVideojuegos(detallePrestamo.getVideojuegos());
            return detallePrestamoService.guardarDetallePrestamo(detallePrestamoExistente);
        }
        return null;
    }

    //eliminar detallePrestamo
    @DeleteMapping("/{id}")
    public void eliminarDetallePrestamo(@PathVariable Long id) {
        detallePrestamoService.eliminarDetallePrestamo(id);
    }
}
