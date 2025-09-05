package com.itsqmet.proyecto_bd2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "prestamos")
public class Prestamo {
    @Id
    private String id;

    @NotNull(message = "La fecha de préstamo es obligatoria")
    private Date fechaPrestamo;

    @NotNull(message = "La fecha de devolución es obligatoria")
    private Date fechaDevolucion;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @NotBlank(message = "El ID del usuario es obligatorio")
    private String usuarioId;

}
