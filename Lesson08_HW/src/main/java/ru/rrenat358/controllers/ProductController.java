package ru.rrenat358.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
//    @GetMapping("/products/{id}")
    public ResponseEntity<?> findById03(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(
                new AppError(HttpStatus.NOT_FOUND.value(), "Продукт не найден для ID : " + id),
                HttpStatus.NOT_FOUND
        );
    }

    // variant 04
    // самый верный
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Продукт не найден для ID : " + id));
    }







    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable  Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/change_price")
    public void changePrice(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changePrice(productId, delta);
    }

    @GetMapping("/products/price_between")
    public List<Product> findAllByPriceBetween(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "1000") Integer max) {
        return productService.findAllByPriceBetween(min, max);
    }



    @GetMapping("/products/price_belowlimit")
    public List<Product> findAllByPriceBelowLimit(@RequestParam(defaultValue = "0") Integer maxLimit) {
        return productService.findAllByPriceBelowLimit(maxLimit);
    }

    @GetMapping("/products/price_abovelimit")
    public List<Product> findAllByPriceAboveLimit(@RequestParam(defaultValue = "0") Integer minLimit) {
        return productService.findAllByPriceAboveLimit(minLimit);
    }




}
