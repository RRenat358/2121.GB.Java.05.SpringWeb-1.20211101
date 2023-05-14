package ru.rrenat358.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.rrenat358.entities.Product;
import ru.rrenat358.service.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {


    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable  Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/change_price")
    public void changePrice() {
        productService.changePrice();
    }




}
