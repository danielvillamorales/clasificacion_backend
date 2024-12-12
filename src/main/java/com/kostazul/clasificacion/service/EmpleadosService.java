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

    /**
     * busca todos los empleados
     *
     * @return List<Empleados>
     */
    public List<Empleados> findAll() {
        return empleadosRepository.findAll();
    }

    /**
     * busca un empleado
     *
     * @param empleado empleado
     * @return Empleados
     */
    public Empleados findByEmpleado(Long empleado) {
        return empleadosRepository.findByEmpleado(empleado)
                .orElseThrow(() -> new RuntimeException("Empleado" + empleado + "no encontrado"));
    }

}
