package com.kostazul.clasificacion.service;

import com.kostazul.clasificacion.model.entity.DotacionElementos;
import com.kostazul.clasificacion.model.entity.DotacionEntregada;
import com.kostazul.clasificacion.model.entity.Empleados;
import com.kostazul.clasificacion.model.repository.DotacionEntregaRepository;
import com.kostazul.clasificacion.utils.exceptions.FormatInvalidException;
import com.kostazul.clasificacion.utils.tools.DateTransform;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DotacionEntregadaService {

    private final DotacionEntregaRepository dotacionEntregadaRepository;

    private final DotacionElementosService dotacionElementosService;

    private final EmpleadosService empleadosService;

    /**
     * Guarda las dotaciones entregadas
     *
     * @param datos datos
     * @return List<DotacionEntregada>
     */
    public List<DotacionEntregada> saveDotacionEntregadas(final List<String> datos) {
        log.warn("saveDotacionEntregadas");

        DotacionEntregada ultimaDotacion = dotacionEntregadaRepository.findTopByOrderByIdDesc();
        long ultimoId = (ultimaDotacion.getId() > 0) ? ultimaDotacion.getId() : 0L;
        List<DotacionEntregada> dotacionEntregadas = new ArrayList<>();

        for (String dato : datos) {
            String[] parts = dato.split(",");
            if (parts.length != 6) {
                throw new FormatInvalidException("Error en el formato de los datos");
            }
            Long empleadoCodigo = Long.parseLong(parts[0]);
            String dotacionCodigo = parts[1].toUpperCase();
            Long cantidad = Long.parseLong(parts[2]);
            Long precio = Long.parseLong(parts[3]);
            Date fecha = DateTransform.parseDate(parts[4]);
            String descripcionProducto = parts[5].toUpperCase();

            Empleados empleado = empleadosService.findByEmpleado(empleadoCodigo);
            DotacionElementos dotacion = dotacionElementosService.saveDotacionElementos(dotacionCodigo,
                    descripcionProducto,
                    precio);

            if (empleado != null && dotacion != null) {
                ultimoId = ultimoId + 1L;
                DotacionEntregada dotacionEntregada = DotacionEntregada.builder()
                        .id(ultimoId)
                        .empleado(empleado.getId())
                        .dotacion(dotacion.getId())
                        .cantidad(cantidad)
                        .talla("u")
                        .valorunitario(precio)
                        .usuariodecreacion("NOMINA")
                        .fecha(fecha)
                        .fechahoradecreacion(new Date())
                        .observaciones("Dotacion entregada")
                        .build();
                dotacionEntregadas.add(dotacionEntregada);
            }

        }
        return dotacionEntregadaRepository.saveAll(dotacionEntregadas);
    }


}
