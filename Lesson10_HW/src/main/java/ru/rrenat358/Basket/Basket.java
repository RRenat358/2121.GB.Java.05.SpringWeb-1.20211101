package ru.rrenat358.Basket;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.rrenat358.entities.Product;

import javax.annotation.PostConstruct;
import java.util.HashSet;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket {

    private HashSet<Product> products;

    @PostConstruct
    void init() {
        products = new HashSet<>();
    }


    public HashSet<Product> addToBasket(Product product) {
        products.add(product);
        return products;
    }



}
