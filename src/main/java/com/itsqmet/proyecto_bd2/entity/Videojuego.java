package com.itsqmet.proyecto_bd2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //titulo
    private String titulo;
    //genero
    private String genero;
    //stock
    private Integer stock;
    //plataforma
    private String plataforma;
    //precio Unitario
    private Double precio;

}
