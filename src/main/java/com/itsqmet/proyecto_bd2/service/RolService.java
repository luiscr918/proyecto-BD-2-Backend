package com.itsqmet.proyecto_bd2.service;

import com.itsqmet.proyecto_bd2.model.Rol;
import com.itsqmet.proyecto_bd2.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerPorId(Integer id) {
        return rolRepository.findById(id);
    }

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    public void eliminar(Integer id) {
        rolRepository.deleteById(id);
    }
}
