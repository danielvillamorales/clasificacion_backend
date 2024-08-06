package com.kostazul.clasificacion.web.controller;

import com.kostazul.clasificacion.model.entity.DotacionEntregada;
import com.kostazul.clasificacion.service.DotacionEntregadaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrega-dotacion")
@AllArgsConstructor
@CrossOrigin
@Slf4j
public class EntregaDotacionController {

    private DotacionEntregadaService dotacionEntregadaService;

    @PostMapping
    public ResponseEntity<List<DotacionEntregada>> saveListado(@RequestBody List<String> datos) {
        log.warn(datos.toString());
        return new ResponseEntity<>(dotacionEntregadaService.saveDotacionEntregadas(datos)
                , HttpStatus.OK);
    }
}
