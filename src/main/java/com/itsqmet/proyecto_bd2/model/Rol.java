package com.itsqmet.proyecto_bd2.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "roles")
public class Rol {
    @Id
    private Integer id;

    @NotNull(message = "El rol es obligatorio")
    private String nombre;
}
