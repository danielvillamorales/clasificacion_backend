package com.kostazul.clasificacion.web.controller;


import com.kostazul.clasificacion.model.entity.ClasificacionPrendas;
import com.kostazul.clasificacion.service.ClasificacionPrendasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clasificacion")
@AllArgsConstructor
@CrossOrigin
public class ClasificacionPrendasController {

    /**
     * servicio.
     */
    private final ClasificacionPrendasService clasificacionPrendasService;

    /**
     * buscar por codigo de barras o referencia.
     * @param valor valor
     * @return lista de clasificacion de prendas
     */
    @GetMapping
    public ResponseEntity<List<ClasificacionPrendas>> getByCodbarOrReferencia(@RequestParam  String valor){
        return new ResponseEntity<>(clasificacionPrendasService.searchByCodbar(valor), HttpStatus.OK);
    }

}
