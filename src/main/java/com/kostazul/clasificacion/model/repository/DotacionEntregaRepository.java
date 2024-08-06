package com.kostazul.clasificacion.model.repository;

import com.kostazul.clasificacion.model.entity.DotacionEntregada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DotacionEntregaRepository extends JpaRepository<DotacionEntregada, Long> {

    /**
     * buscar el ultimo id de la tabla
     */
    DotacionEntregada findTopByOrderByIdDesc();
}
