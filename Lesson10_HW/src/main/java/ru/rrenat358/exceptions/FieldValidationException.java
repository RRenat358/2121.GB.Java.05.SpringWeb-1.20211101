package ru.rrenat358.exceptions;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class FieldValidationException extends RuntimeException {

    private List<String> errorMessages;

    public FieldValidationException(List<String> errorMessages) {

        super(errorMessages.stream().collect(Collectors.joining("\n----------\n")));
        this.errorMessages = errorMessages;

    }


}
