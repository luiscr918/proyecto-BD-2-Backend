package com.itsqmet.proyecto_bd2.repository;

import com.itsqmet.proyecto_bd2.entity.DetallePrestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePrestamoRepository extends JpaRepository<DetallePrestamo,Long> {
}
