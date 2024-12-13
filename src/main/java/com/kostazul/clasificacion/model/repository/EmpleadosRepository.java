package com.kostazul.clasificacion.model.repository;

import com.kostazul.clasificacion.model.entity.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {

    /**
     * busca un empleado
     *
     * @param empleados empleado
     * @return Empleados
     */
    Optional<Empleados> findByEmpleado(Long empleados);
}
