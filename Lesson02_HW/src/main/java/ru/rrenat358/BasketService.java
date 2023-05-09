package ru.rrenat358;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class BasketService {

//    @Autowired
    private ProductService productService;

    private HashSet<Product> basketService;

    public BasketService(ProductService productService, HashSet<Product> basketService) {
        this.productService = productService;
        this.basketService = basketService;
    }

    public void addById(Long id) {
        Product p = productService.getProductById(id);
        basketService.add(p);
    }


}
