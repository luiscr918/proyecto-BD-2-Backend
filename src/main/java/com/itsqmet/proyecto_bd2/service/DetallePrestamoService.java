package com.itsqmet.proyecto_bd2.service;

import com.itsqmet.proyecto_bd2.entity.DetallePrestamo;
import com.itsqmet.proyecto_bd2.repository.DetallePrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePrestamoService {
    @Autowired
    private DetallePrestamoRepository detallePrestamoRepository;
    //Lista de detalle prestamo
    public List<DetallePrestamo> allDetallePrestamos(){
        return detallePrestamoRepository.findAll();
    }

    //buscar por id(para actualizar y eliminar)
    public Optional<DetallePrestamo> buscarDetallePrestamoId(Long id){
        return detallePrestamoRepository.findById(id);
    }
    //Guardar detalle prestamo
    public DetallePrestamo guardarDetallePrestamo(DetallePrestamo detallePrestamo){
        return detallePrestamoRepository.save(detallePrestamo);
    }
    //Eliminar detalle prestamo
    public void eliminarDetallePrestamo(Long id){
        detallePrestamoRepository.deleteById(id);
    }
}
