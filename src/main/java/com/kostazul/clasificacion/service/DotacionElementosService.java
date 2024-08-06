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
}
