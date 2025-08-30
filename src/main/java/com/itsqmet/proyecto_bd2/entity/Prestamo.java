package com.itsqmet.proyecto_bd2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //fecha de prestamo
    @NotNull(message = "La fecha de préstamo es obligatoria")
    @FutureOrPresent(message = "La fecha de préstamo no puede ser en el pasado")
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    //fecha devolucion
    @NotNull(message = "La fecha de devolución es obligatoria")
    @FutureOrPresent(message = "La fecha de devolución debe ser igual o posterior a hoy")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    //estado
    @NotBlank(message = "El estado es obligatorio")
    private String estado;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "prestamo")
    private List<DetallePrestamo> detalles;


}
