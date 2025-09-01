package com.itsqmet.proyecto_bd2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaPrestamo;
    //fecha devolucion
    @NotNull(message = "La fecha de devolución es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
