package com.itsqmet.proyecto_bd2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class DetallePrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //cantidad
    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer cantidad;
    //total
    @NotNull(message = "El total es obligatorio")
    @Min(value = 1, message = "El total debe ser mayor a 0")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "prestamo_id")
    private Prestamo prestamo;

    @OneToMany(mappedBy = "detallePrestamo")
    private List<Videojuego> videojuegos;

}
