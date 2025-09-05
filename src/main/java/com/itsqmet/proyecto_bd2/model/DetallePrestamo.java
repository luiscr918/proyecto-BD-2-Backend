package com.itsqmet.proyecto_bd2.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "detalle_prestamos")
public class DetallePrestamo {
    @Id
    private String id;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser mínimo 1")
    private Integer cantidad;

    @NotNull(message = "El subtotal es obligatorio")
    @Min(value = 1, message = "El subtotal debe ser mayor a 0")
    private Double subtotal;

    @NotNull(message = "El total es obligatorio")
    @Min(value = 1, message = "El total debe ser mayor a 0")
    private Double total;

    @NotBlank(message = "El ID del préstamo es obligatorio")
    private String prestamoId;

    @NotBlank(message = "El ID del videojuego es obligatorio")
    private String videojuegoId;
}
