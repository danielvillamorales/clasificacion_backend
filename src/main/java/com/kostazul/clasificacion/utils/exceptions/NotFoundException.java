package com.kostazul.clasificacion.utils.exceptions;

public class NotFoundException extends RuntimeException {
    /**
     * Constructor
     *
     * @param message mensaje
     */
    public NotFoundException(String message) {
        super(message);
    }
}
