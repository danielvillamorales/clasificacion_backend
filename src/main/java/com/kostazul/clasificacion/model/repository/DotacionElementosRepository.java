package com.kostazul.clasificacion.model.repository;

import com.kostazul.clasificacion.model.entity.DotacionElementos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DotacionElementosRepository extends JpaRepository<DotacionElementos, Long> {

    /**
     * Busca por codigo
     * @param codigo codigo
     * @return DotacionElementos
     */
    Optional<DotacionElementos> findByCodigo(String codigo);

    /**
     * Busca el ultimo elemento
     * @return DotacionElementos
     */
    DotacionElementos findTopByOrderByIdDesc();
}
