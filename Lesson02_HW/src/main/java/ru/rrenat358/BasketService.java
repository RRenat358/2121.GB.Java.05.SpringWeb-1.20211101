package ru.rrenat358;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class BasketService {

    @Autowired
    private ProductService productService;


    private HashSet<Product> inBasket = new HashSet<>();


    public void addById(Long id) {
        Product p = productService.getProductById(id);
        inBasket.add(p);
    }

//    public HashSet<Product> showBasket() {
//        return inBasket;
//    }

    void showBasket() {
        for (Product product : inBasket) {
            System.out.println(product);
        }
    }


}
