package com.kostazul.clasificacion.service;

import com.kostazul.clasificacion.model.entity.DotacionElementos;
import com.kostazul.clasificacion.model.repository.DotacionElementosRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DotacionElementosService {

    private final DotacionElementosRepository dotacionElementosRepository;


    public List<DotacionElementos> findAll() {
        return dotacionElementosRepository.findAll();
    }

    /**
     * Guarda un elemento de dotacion
     * @param codigo codigo
     * @param descripcion descripcion
     * @param precio precio
     * @return DotacionElementos guardada o encontrada
     */
    public DotacionElementos saveDotacionElementos(String codigo, String descripcion, Long precio) {
        log.warn("saveDotacionElementos");
        return dotacionElementosRepository.findByCodigo(codigo).orElseGet(() -> save(codigo, descripcion, precio));
    }

    /**
     * Guarda un elemento de dotacion
     * @param codigo codigo
     * @param descripcion descripcion
     * @param precio precio
     * @return DotacionElementos guardada
     */
    public DotacionElementos save(String codigo, String descripcion, Long precio){
        return dotacionElementosRepository.save(DotacionElementos.builder()
                        .id(generateNextId())
                        .codigo(codigo)
                        .descripcion(descripcion)
                        .observaciones("dotacion" + " " + codigo + ": " + descripcion)
                        .valorUnitario(precio)
                        .usuarioCreacion("nomina")
                        .fechaCreacion(new java.util.Date())
                .build());
    }

    /**
     * Genera el siguiente id
     * @return Long
     */
    public Long generateNextId() {
        DotacionElementos lastElement = dotacionElementosRepository.findTopByOrderByIdDesc();
        return (lastElement != null) ? lastElement.getId() + 1 : 1L;
    }
}
