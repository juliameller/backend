package com.example.exercicio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ApiErrorDto> handleValidationError(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getAllErrors().stream().map((ex) -> {
            return new ApiErrorDto("Erro de validação", ex.getObjectName() + ": " + ex.getDefaultMessage(), Instant.now());
        }).toList();
    }
}
