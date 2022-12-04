package dev.carmanager.Car.exceptions;

import dev.carmanager.Car.model.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceCarAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDTO> handleRuntimeException(RuntimeException e){

            return ResponseEntity.badRequest().body(ErrorDTO.builder().message(e.getMessage()).codeError("400").build());

    }

}
