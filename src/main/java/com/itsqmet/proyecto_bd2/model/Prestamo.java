package com.itsqmet.proyecto_bd2.model;

import jakarta.validation.constraints.Min;
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
    //de una vez el detalle aqui
    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser mínimo 1")
    private Integer cantidad;

    @NotNull(message = "El subtotal es obligatorio")
    @Min(value = 1, message = "El subtotal debe ser mayor a 0")
    private Double subtotal;

    @NotNull(message = "El total es obligatorio")
    @Min(value = 1, message = "El total debe ser mayor a 0")
    private Double total;
    @NotBlank(message = "El ID del videojuego es obligatorio")
    private String videojuegoId;

    @NotBlank(message = "El ID del usuario es obligatorio")
    private String usuarioId;

}
