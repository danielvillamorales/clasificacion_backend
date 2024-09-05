package com.kostazul.clasificacion.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clasificacion_de_prendas")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClasificacionPrendas {

    /**
     * identificador de la clasificacion de prendas.
     */
    @Id
    private Long id;

    /**
     * referencia del producto.
     */
    private String referencia;

    /**
     * consecutivo del item.
     */
    private Long consecutivo;

    /**
     * codigo del color del producto.
     */
    @Column(name = "codcolor", nullable = true)
    private String codcolor;

    /**
     * producto
     */
    private String producto;

    /**
     * tiquete
     */
    private Long tiquete;

    /**
     * referencia
     */
    private String codbar;

    /**
     * descripcion
     */
    private String descgrupo;

    /**
     * grupo
     */
    private String grupo;

    /**
     * coleccion
     */
    private String coleccion;

    /**
     * subgrupo
     */
    private String subgrupo;

    /**
     * subgrupo
     */
    private String descsubgrupo;

    /**
     * diseno
     */
    private String diseno;

    /**
     * concepto
     */
    private String concepto;

    /**
     * composicion
     */
    private String composicion;

    /**
     * clasificacion
     */
    private String clasificacion;
}
