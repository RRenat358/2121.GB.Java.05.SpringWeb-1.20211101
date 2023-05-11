package ru.rrenat358.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rrenat358.entities.Product;
import ru.rrenat358.services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<Product> findById() {
        return productService.findAll();
    }


    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }


    //todo
    @GetMapping("/products/change_score")
    public void changeScore(@RequestParam Long productId, @RequestParam Integer delta) {
        Product p = productService.findById(productId);
        p.getPrice();
    }
}
