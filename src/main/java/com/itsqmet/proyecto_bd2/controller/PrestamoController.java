package com.itsqmet.proyecto_bd2.controller;

import com.itsqmet.proyecto_bd2.entity.Prestamo;
import com.itsqmet.proyecto_bd2.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prestamo")
/*@CrossOrigin(origins = "http://localhost:4200")*/
public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;
    //leer todos los prestamos
    @GetMapping
    public List<Prestamo> mostrarPrestamos() {
        return prestamoService.allPrestamos();
    }

    //guardar nuevo prestamo
    @PostMapping
    public Prestamo guardarPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoService.guardarPrestamo(prestamo);
    }
    //Buscar Prestamo por id
    @GetMapping("/{id}")
    public Optional<Prestamo> buscarPrestamoId(@PathVariable Long id){
        return prestamoService.buscarPrestamoId(id);
    }
    //actualizar prestamo
    @PutMapping("/{id}")
    public Prestamo actualizarPrestamo(@PathVariable Long id, @RequestBody Prestamo prestamo) {
        Optional<Prestamo> prestamoOptional = prestamoService.buscarPrestamoId(id);
        if (prestamoOptional.isPresent()) {
            Prestamo PrestamoExistente = prestamoOptional.get();
            PrestamoExistente.setFechaPrestamo(prestamo.getFechaPrestamo());
            PrestamoExistente.setFechaDevolucion(prestamo.getFechaDevolucion());
            PrestamoExistente.setEstado(prestamo.getEstado());
            PrestamoExistente.setCliente(prestamo.getCliente());
            PrestamoExistente.setDetalles(prestamo.getDetalles());
            return prestamoService.guardarPrestamo(PrestamoExistente);
        }
        return null;
    }

    //eliminar prestamo
    @DeleteMapping("/{id}")
    public void eliminarPrestamo(@PathVariable Long id) {
        prestamoService.eliminarPrestamo(id);
    }
}
