package ru.rrenat358.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class FieldsValidationError {

    private List<String> fieldsValidationError;

    public FieldsValidationError(List<String> fieldsValidationError) {
        this.fieldsValidationError = fieldsValidationError;
    }

}
