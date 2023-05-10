package ru.rrenat358;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class BasketService {

    @Autowired
    private ProductService productService;

    private HashSet<Product> inBasket;


    @PostConstruct
    void init() {
        inBasket = new HashSet<>();
    }




    public void addById(Long id) {
        Product p = productService.getProductById(id);
        inBasket.add(p);
    }

    public void removeById(Long id) {
        Product p = productService.getProductById(id);
        inBasket.remove(p);
    }





    void showBasket() {
        for (Product product : inBasket) {
            System.out.println(product);
        }
    }


}
