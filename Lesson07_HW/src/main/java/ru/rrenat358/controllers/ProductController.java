package ru.rrenat358.controllers;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.rrenat358.entities.Product;
import ru.rrenat358.exceptions.AppError;
import ru.rrenat358.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {


    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }




    // variant 01
//    @GetMapping("/products/{id}")
    public Optional<Product> findById01(@PathVariable Long id) {
        return productService.findById(id);
    }

    // variant 02
//    @GetMapping("/products/{id}")
    public ResponseEntity<?> findById02(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // variant 03
    @GetMapping("/products/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(
                new AppError(HttpStatus.NOT_FOUND.value(), "Продукт не найден для ID : " + id),
                HttpStatus.NOT_FOUND
        );
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
