package ru.rrenat358;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> products;

    @PostConstruct
    void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Яблоки"),
                new Product(2L, "Бананы"),
                new Product(3L, "Киви"),
                new Product(4L, "Ананас"),
                new Product(5L, "Редис")
        ));
    }


    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }


    @Override
    public Product findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new RuntimeException());
    }



}
