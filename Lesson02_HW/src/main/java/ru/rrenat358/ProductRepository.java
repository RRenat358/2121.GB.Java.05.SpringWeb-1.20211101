package ru.rrenat358;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Яблоки"),
                new Product(1L, "Бананы>"),
                new Product(1L, "Киви"),
                new Product(1L, "Ананас"),
                new Product(1L, "Редис")
        ));
    }


    public Product findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new RuntimeException());
    }


}
