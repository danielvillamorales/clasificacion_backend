package com.kostazul.clasificacion.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "empleados_dotacionentregada")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DotacionEntregada {

    @Id
    private Long id;

    private Date fecha;

    @Column(name = "empleadoid")
    private Long empleado;

    @Column(name = "dotacionid")
    private Long dotacion;

    private String talla;

    private Long cantidad;

    private String observaciones;

    private Date fechahoradecreacion;

    @Column(name = "usuariodecreacion")
    private String usuariodecreacion;

    private Long valorunitario;

    private Long nominaelectronicadetid;

}
