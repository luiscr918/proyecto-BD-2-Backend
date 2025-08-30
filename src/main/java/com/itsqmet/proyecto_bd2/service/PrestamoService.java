package com.itsqmet.proyecto_bd2.service;

import com.itsqmet.proyecto_bd2.entity.Prestamo;
import com.itsqmet.proyecto_bd2.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {
    @Autowired
    private PrestamoRepository prestamoRepository;
    //Lista de prestamos
    public List<Prestamo> allPrestamos(){
        return prestamoRepository.findAll();
    }

    //buscar por id(para actualizar y eliminar)
    public Optional<Prestamo> buscarPrestamoId(Long id){
        return prestamoRepository.findById(id);
    }
    //Guardar prestamo
    public Prestamo guardarPrestamo(Prestamo prestamo){
        return prestamoRepository.save(prestamo);
    }
    //Eliminar prestamo
    public void eliminarPrestamo(Long id){
        prestamoRepository.deleteById(id);
    }
}
