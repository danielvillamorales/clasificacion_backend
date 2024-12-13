package com.kostazul.clasificacion.utils.factory;

import com.kostazul.clasificacion.utils.exceptions.ErrorDetails;

import java.util.Date;

public final class ErrosFactory {
    /**
     * Constructor privado.
     */
    private ErrosFactory() {
    }

    /**
     * Crea un error de formato invalido.
     *
     * @param ex mensaje
     * @return FormatInvalidException
     */
    public static ErrorDetails create(RuntimeException ex) {
        return ErrorDetails.builder()
                .message(ex.getMessage())
                .timestamp(new Date())
                .details(ex.getClass().getSimpleName())
                .build();
    }
}
