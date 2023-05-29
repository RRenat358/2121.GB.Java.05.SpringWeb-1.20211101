package ru.rrenat358.validators;

import org.springframework.stereotype.Component;
import ru.rrenat358.dto.ProductDto;
import ru.rrenat358.exceptions.FieldValidationException;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProductValidator {

    public void validator(ProductDto productDto) {

        List<String> errorMessages = new ArrayList<>();

        if (productDto.getName().trim().isEmpty()) {
            errorMessages.add("Имя отсутствует !!!");
        }
        if (productDto.getPrice() < 0) {
            errorMessages.add("Цена < 0 !!!");
        }


        if (!errorMessages.isEmpty()) {
            throw new FieldValidationException(errorMessages);
        }


    }



}
