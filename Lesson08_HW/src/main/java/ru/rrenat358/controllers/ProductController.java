package ru.rrenat358.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.entities.Product;
import ru.rrenat358.exceptions.AppError;
import ru.rrenat358.exceptions.ResourceNotFoundException;
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


    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Продукт не найден для ID : " + id));
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }


    //============================================================
    // ФИЛЬТЫ

    @GetMapping("/products/change_price")
    public void changePrice(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changePrice(productId, delta);
    }

    // http://localhost:8189/app/products/price_between?min=50&max70
    @GetMapping("/products/price_between")
    public List<Product> findAllByPriceBetween(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "1000") Integer max) {
        return productService.findAllByPriceBetween(min, max);
    }



    //==============================
    // http://localhost:8189/app/products/price_belowlimit?maxLimit=50
    @GetMapping("/products/price_belowlimit")
    public List<Product> findAllByPriceBelowLimit(@RequestParam(defaultValue = "0") Integer maxLimit) {
        return productService.findAllByPriceBelowLimit(maxLimit);
    }

    @GetMapping("/products/price_abovelimit")
    public List<Product> findAllByPriceAboveLimit(@RequestParam(defaultValue = "0") Integer minLimit) {
        return productService.findAllByPriceAboveLimit(minLimit);
    }


    //============================================================
    // POST

    @PostMapping("/products")
    public Product saveNewProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }


}
