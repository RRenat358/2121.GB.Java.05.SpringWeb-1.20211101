package ru.rrenat358.Basket;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.rrenat358.converters.ProductConverter;
import ru.rrenat358.dto.ProductDto;
import ru.rrenat358.entities.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
@RequiredArgsConstructor
//@NoArgsConstructor
//@AllArgsConstructor
public class Basket {

    private List<Product> products;

    private final ProductConverter productConverter;


    @PostConstruct
    void init() {
        products = new ArrayList<>();
    }

    public List<Product> basket() {
        return products;
    }

    public List<Product> addToBasket(Product product) {
//        Product product = productConverter.entityToDto(product);
        products.add(product);
        return products;
    }

    public List<Product> removeFromBasket(Product product) {
//        Product product = productConverter.entityToDto(product);
//        products.add(product);
        return products;
    }

    public List<Product> clearBasket() {
        products.clear();
        return products;
    }



}
