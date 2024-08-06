package com.kostazul.clasificacion.service;

import com.kostazul.clasificacion.model.entity.Empleados;
import com.kostazul.clasificacion.model.repository.EmpleadosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpleadosService {

    private final EmpleadosRepository empleadosRepository;

    public List<Empleados> findAll() {
        return empleadosRepository.findAll();
    }

}
