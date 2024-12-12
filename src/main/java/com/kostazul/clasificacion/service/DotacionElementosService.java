package com.kostazul.clasificacion.service;

import com.kostazul.clasificacion.model.entity.DotacionElementos;
import com.kostazul.clasificacion.model.repository.DotacionElementosRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Service;

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
        DotacionElementos dotacionElementos = dotacionElementosRepository.findByCodigo(codigo).orElse(
                save(codigo, descripcion, precio)
        );
        return dotacionElementosRepository.save(dotacionElementos);
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
                        .codigo(codigo)
                        .descripcion(descripcion)
                        .observaciones("dotacion" + " " + codigo + ": " + descripcion)
                        .valorUnitario(precio)
                        .usuarioCreacion("nomina")
                        .fechaCreacion(new java.util.Date())
                .build());
    }
}
