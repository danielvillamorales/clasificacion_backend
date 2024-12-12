package com.kostazul.clasificacion.web.controller;

import com.kostazul.clasificacion.model.entity.DotacionElementos;
import com.kostazul.clasificacion.service.DotacionElementosService;
import lombok.AllArgsConstructor;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dotacion-elementos")
@AllArgsConstructor
@CrossOrigin
@Slf4j
public class DotacionElementosController {

    private DotacionElementosService dotacionElementosService;

    /**
     * Obtiene todos los elementos de dotacion
     * @return List<DotacionElementos>
     */
    @GetMapping
    public ResponseEntity<List<DotacionElementos>> getDotacionElementos() {
        log.warn("getDotacionElementos");
        return new ResponseEntity<>(dotacionElementosService.findAll(), HttpStatus.OK);
    }
}
