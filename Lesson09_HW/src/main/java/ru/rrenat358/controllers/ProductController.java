package ru.rrenat358.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.entities.Product;
import ru.rrenat358.exceptions.ResourceNotFoundException;
import ru.rrenat358.service.ProductService;

import java.util.List;

@RestController
public class ProductController {


    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/products")
//    public List<Product> findAll() {
//        return productService.findAll();
//    }


    @GetMapping("/products")
    public Page<Product> findByFilter(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "minPrice", required = false) Integer minPrice,
            @RequestParam(name = "maxPrice", required = false) Integer maxPrice,
            @RequestParam(name = "namePart", required = false) String namePart
            ) {
        if (page < 1) {
            page = 1;
        }
        return productService.findByFilter(page, minPrice, maxPrice, namePart);
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

    // NoUsed
//    @GetMapping("/products/change-price")
//    public void changePrice(@RequestParam Long productId, @RequestParam Integer delta) {
//        productService.changePrice(productId, delta);
//    }

    @GetMapping("/products/change-price-to-delta")
    public void changePriceToDelta(@RequestParam Long id, @RequestParam Integer delta) {
        productService.changePriceToDelta(id, delta);
    }

    // http://localhost:8189/app/products/price_between?min=50&max70
    @GetMapping("/products/price-between")
    public List<Product> findAllByPriceBetween(
            @RequestParam(defaultValue = "0") Integer min,
            @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer max // Integer.toString = 2147483647
            ) {
        return productService.findAllByPriceBetween(min, max);
    }



    //==============================
    // http://localhost:8189/app/products/price-belowlimit?maxLimit=50
    @GetMapping("/products/price-belowlimit")
    public List<Product> findAllByPriceBelowLimit(@RequestParam(defaultValue = "0") Integer maxLimit) {
        return productService.findAllByPriceBelowLimit(maxLimit);
    }

    @GetMapping("/products/price-abovelimit")
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
