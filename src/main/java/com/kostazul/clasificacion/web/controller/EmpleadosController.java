package com.kostazul.clasificacion.web.controller;

import com.kostazul.clasificacion.model.entity.Empleados;
import com.kostazul.clasificacion.service.EmpleadosService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@AllArgsConstructor
@CrossOrigin
@Slf4j
public class EmpleadosController {

    private final EmpleadosService empleadosService;

    @GetMapping
    ResponseEntity<List<Empleados>> findAll() {
        log.warn("findAll");
        return ResponseEntity.ok(empleadosService.findAll());
    }
}
