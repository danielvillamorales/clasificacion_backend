package com.kostazul.clasificacion.service;

import com.kostazul.clasificacion.model.entity.DotacionElementos;
import com.kostazul.clasificacion.model.entity.DotacionEntregada;
import com.kostazul.clasificacion.model.entity.Empleados;
import com.kostazul.clasificacion.model.repository.DotacionElementosRepository;
import com.kostazul.clasificacion.model.repository.DotacionEntregaRepository;
import com.kostazul.clasificacion.model.repository.EmpleadosRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
@AllArgsConstructor
@Slf4j
public class DotacionEntregadaService {

    private final DotacionEntregaRepository dotacionEntregadaRepository;

    private final DotacionElementosRepository dotacionElementosRepository;

    private final EmpleadosRepository empleadosRepository;

    public List<DotacionEntregada> saveDotacionEntregadas(final List<String> datos) {
        log.warn("saveDotacionEntregadas");

        DotacionEntregada ultima_dotacion = dotacionEntregadaRepository.findTopByOrderByIdDesc();
        Long ultimo_id = (ultima_dotacion.getId() > 0) ? ultima_dotacion.getId() : 0L;
        List<DotacionEntregada> dotacionEntregadas = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (String dato : datos) {
            String[] parts = dato.split(",");
            if (parts.length == 5) {
                Long empleadoCodigo = Long.parseLong(parts[0]);
                String dotacionCodigo = parts[1];
                Long cantidad = Long.parseLong(parts[2]);
                Long precio = Long.parseLong(parts[3]);
                Date fecha = new Date();
                try {
                    fecha = dateFormat.parse(parts[4]);
                } catch (ParseException e) {
                    new RuntimeException("Error en la fecha debe estar en formato yyyy-mm-dd");
                }

                Empleados empleado = empleadosRepository.findByEmpleado(empleadoCodigo)
                        .orElseThrow(() -> new RuntimeException("Empleado" + empleadoCodigo + "no encontrado"));
                DotacionElementos dotacion = dotacionElementosRepository.findByCodigo(dotacionCodigo)
                        .orElseThrow(() -> new RuntimeException("Dotacion" + dotacionCodigo + "no encontrado"));

                if (empleado != null && dotacion != null) {
                    ultimo_id = ultimo_id + 1L;
                    DotacionEntregada dotacionEntregada = DotacionEntregada.builder()
                            .id(ultimo_id)
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
            } else {
                throw new RuntimeException("Error en el formato de los datos");
            }
        }

        return dotacionEntregadaRepository.saveAll(dotacionEntregadas);
    }
}
