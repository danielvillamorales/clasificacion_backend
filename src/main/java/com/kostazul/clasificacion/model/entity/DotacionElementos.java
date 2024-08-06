package com.kostazul.clasificacion.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
@Table(name = "nop_dotacionelementos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DotacionElementos {

    @Id
    private Long id;

    @Column(name = "codigo", length = 50)
    private String codigo;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @Column(name = "asignarempleadosnuevos", columnDefinition = "int default 0" )
    private int empleadosNuevos;

    @Column(name = "observaciones", length = 4000)
    private String observaciones;

    @Column(name = "fechahoradecreacion")
    private Date fechaCreacion;

    @Column(name = "usuariodecreacion", length = 10)
    private String usuarioCreacion;

    @Column(name = "valorunitario")
    private Long valorUnitario;

}
