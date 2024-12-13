package com.kostazul.clasificacion.utils.exceptions;

import com.kostazul.clasificacion.utils.factory.ErrosFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDetails> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(ErrosFactory.create(ex), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FormatInvalidException.class)
    public ResponseEntity<ErrorDetails> handleFormatInvalidException(FormatInvalidException ex) {
        return new ResponseEntity<>(ErrosFactory.create(ex), HttpStatus.BAD_REQUEST);
    }
}
