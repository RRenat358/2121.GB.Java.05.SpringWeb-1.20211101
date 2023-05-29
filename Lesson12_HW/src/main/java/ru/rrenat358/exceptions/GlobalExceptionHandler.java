package ru.rrenat358.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<AppError> catchResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        log.error(resourceNotFoundException.getMessage(), resourceNotFoundException);
        return new ResponseEntity<>(new AppError(
                HttpStatus.NOT_FOUND.value(),
                resourceNotFoundException.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<FieldsValidationError> catchFieldValidationException(FieldValidationException fieldValidationException) {
        log.error(fieldValidationException.getMessage(), fieldValidationException);
        return new ResponseEntity<>(new FieldsValidationError(
                fieldValidationException.getErrorMessages()),
                HttpStatus.BAD_REQUEST);
    }

}
