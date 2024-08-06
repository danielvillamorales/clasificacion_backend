package com.kostazul.clasificacion.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleados")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Empleados {

    @Id
    private Long id;

    private Long codigo;

    private Long empleado;

    private String nombre;
}
