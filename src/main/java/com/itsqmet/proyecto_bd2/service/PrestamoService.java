package com.itsqmet.proyecto_bd2.service;

import com.itsqmet.proyecto_bd2.model.Prestamo;
import com.itsqmet.proyecto_bd2.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {
    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> obtenerTodos() {
        return prestamoRepository.findAll();
    }

    public Optional<Prestamo> obtenerPorId(String id) {
        return prestamoRepository.findById(id);
    }

    public Prestamo guardar(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public void eliminar(String id) {
        prestamoRepository.deleteById(id);
    }

    public List<Prestamo> obtenerPorUsuario(String usuarioId) {
        return prestamoRepository.findByUsuarioId(usuarioId);
    }

    public List<Prestamo> obtenerPorEstado(String estado) {
        return prestamoRepository.findByEstado(estado);
    }
}
