package com.kostazul.clasificacion.model.repository;

import com.kostazul.clasificacion.model.entity.ClasificacionPrendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasificacionPrendasRepository extends JpaRepository<ClasificacionPrendas, Long>{

    /**
     * buscar por codigo de barras.
     * @param codbar
     * @return
     */
    List<ClasificacionPrendas> findByCodbarOrProducto(String codbar, String producto);
}
