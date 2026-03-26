package com.ecommerce.app.apresentation.controller.handler;

import com.ecommerce.app.apresentation.dto.response.ErrorResponseDTO;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> captureMethodArgument(MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(
                        error -> {
                            errors.put(error.getField(), error.getDefaultMessage());
                        }
                );

        return buildResponse(HttpStatus.BAD_REQUEST, "Dados inválidos: verifique os campos obrigatórios.", errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> captureException(Exception ex){
        ex.printStackTrace();
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null); // ← mostra a mensagem real
    }

    private ResponseEntity<ErrorResponseDTO> buildResponse(HttpStatus  status, String message, Map<String, String> errors){

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                LocalDateTime.now(),
                message,
                status.value(),
                errors
        );

        return ResponseEntity.status(status)
                .body(errorResponseDTO);
    }
}