package ru.rrenat358;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

//    @Autowired
    private List<Product> products;

    @PostConstruct
    void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Яблоки"),
                new Product(2L, "Бананы>"),
                new Product(3L, "Киви"),
                new Product(4L, "Ананас"),
                new Product(5L, "Редис")
        ));
    }


    public Product findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new RuntimeException());
    }


}
