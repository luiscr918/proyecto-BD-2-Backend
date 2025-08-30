package com.itsqmet.proyecto_bd2.repository;

import com.itsqmet.proyecto_bd2.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
