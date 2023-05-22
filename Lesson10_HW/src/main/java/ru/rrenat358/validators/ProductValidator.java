package ru.rrenat358.validators;

import org.springframework.stereotype.Component;
import ru.rrenat358.dto.ProductDto;
import ru.rrenat358.exceptions.ValidationException;


@Component
public class ProductValidator {

    public void validator(ProductDto productDto) {

        if (productDto.getName().trim().isEmpty()) {
            throw new ValidationException("Имя отсутствует !!!");
        }
        if (productDto.getPrice() < 0) {
            throw new ValidationException("Цена < 0 !!!");
        }


    }



}
