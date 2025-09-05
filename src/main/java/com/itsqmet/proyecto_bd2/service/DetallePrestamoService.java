package com.itsqmet.proyecto_bd2.service;

import com.itsqmet.proyecto_bd2.model.DetallePrestamo;
import com.itsqmet.proyecto_bd2.repository.DetallePrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePrestamoService {
    @Autowired
    private DetallePrestamoRepository detallePrestamoRepository;

    public List<DetallePrestamo> obtenerTodos() {
        return detallePrestamoRepository.findAll();
    }

    public Optional<DetallePrestamo> obtenerPorId(String id) {
        return detallePrestamoRepository.findById(id);
    }

    public DetallePrestamo guardar(DetallePrestamo detallePrestamo) {
        return detallePrestamoRepository.save(detallePrestamo);
    }

    public void eliminar(String id) {
        detallePrestamoRepository.deleteById(id);
    }

    public List<DetallePrestamo> obtenerPorPrestamo(String prestamoId) {
        return detallePrestamoRepository.findByPrestamoId(prestamoId);
    }

    public List<DetallePrestamo> obtenerPorVideojuego(String videojuegoId) {
        return detallePrestamoRepository.findByVideojuegoId(videojuegoId);
    }
}
