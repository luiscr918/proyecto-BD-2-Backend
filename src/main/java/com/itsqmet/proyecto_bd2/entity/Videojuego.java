package com.itsqmet.proyecto_bd2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = "El título es obligatorio")
    @Size(min = 2, max = 100, message = "El título debe tener entre 2 y 100 caracteres")
    private String titulo;
    //genero
    @NotBlank(message = "El Genero es obligatorio")
    private String genero;
    //stock
    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;
    //plataforma
    @NotNull(message = "Plataforma de ser obligatoria")
    private String plataforma;
    //precio Unitario
    @NotNull(message = "El precio es obligatorio")
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "detalle_prestamo_id")
    private DetallePrestamo detallePrestamo;

}
