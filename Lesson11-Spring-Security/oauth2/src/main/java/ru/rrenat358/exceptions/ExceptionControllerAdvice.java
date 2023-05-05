package ru.rrenat358.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
        log.error(e.getMessage());
        ServiceError err = new ServiceError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
