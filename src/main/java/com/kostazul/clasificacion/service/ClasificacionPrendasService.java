package com.kostazul.clasificacion.service;

import com.kostazul.clasificacion.model.entity.ClasificacionPrendas;
import com.kostazul.clasificacion.model.repository.ClasificacionPrendasRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ClasificacionPrendasService {


    /**
     * repositorio.
     */
    private final ClasificacionPrendasRepository clasificacionPrendasRepository;


    /**
     * buscar por codigo de barras.
     * @param codbar codigo de barras
     * @return lista de clasificacion de prendas
     */
    public List<ClasificacionPrendas> searchByCodbar(String codbar){
        return clasificacionPrendasRepository.findByCodbarOrProducto(codbar, codbar);
    }
}
