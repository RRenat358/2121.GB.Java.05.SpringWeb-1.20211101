package ru.rrenat358.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.Basket.Basket;
import ru.rrenat358.Basket.BasketService;
import ru.rrenat358.converters.ProductConverter;
import ru.rrenat358.dto.ProductDto;
import ru.rrenat358.entities.Product;
import ru.rrenat358.exceptions.ResourceNotFoundException;
import ru.rrenat358.service.ProductsService;
import ru.rrenat358.validators.ProductValidator;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    private final Basket basket;


    //============================================================
    // GET

    // NoUsed
//    @GetMapping("")
//    public List<Product> findAll() {
//        return productsService.findAll();
//    }

    @GetMapping
    public Page<ProductDto> findByFilter(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "namePart", required = false) String namePart,
            @RequestParam(name = "minPrice", required = false) Integer minPrice,
            @RequestParam(name = "maxPrice", required = false) Integer maxPrice
    ) {
        if (page < 1) {
            page = 1;
        }
        return productsService.findByFilter(page, namePart, minPrice, maxPrice)
                .map(product -> productConverter.entityToDto(product));
    }


    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        Product product = productsService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Продукт не найден для ID : " + id));
        return productConverter.entityToDto(product);
    }



//    public Page<Product> addToBasket(@RequestParam Long id) {
//
//        Product product = productsService.addToBasket(id);
//        basket.addToBasket(product);
//
//        Page<Product> productPage = null;
//        productPage.map(product1 -> basket);
//
//        return productPage;
//    }

    @GetMapping("/basket")
    public Page<Product> addToBasket(@RequestParam Long id) {

        Page<Product> productPage = productsService.addToBasket(id);

        return productPage;
    }






    //============================================================
    // POST

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        productValidator.validator(productDto);
        Product product = productConverter.dtoToEntity(productDto);
        product = productsService.saveProduct(product);
        return productConverter.entityToDto(product);
    }

    //============================================================
    // PATCH

    @PatchMapping("/change-price-to-delta")
    public void changePriceToDelta(@RequestParam Long id, @RequestParam Integer delta) {
        productsService.changePriceToDelta(id, delta);
    }

    // NoUsed
    @PatchMapping("/change-price")
    public void changePrice(@RequestParam Long id, @RequestParam Integer newPrice) {
        productsService.changePrice(id, newPrice);
    }

    //============================================================
    // PUT

    //============================================================
    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Product product = productConverter.dtoToEntity(productDto);
        product = productsService.updateProduct(product);
        return productConverter.entityToDto(product);
    }
    // OR --------------------
//    @PutMapping
//    public ProductDto updateProduct2(@RequestBody ProductDto productDto) {
//        productValidator.validate(productDto);
//        Product product = productsService.update(productDto);
//        return productConverter.entityToDto(product);
//    }
    //============================================================


    //============================================================
    // DELETE

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productsService.deleteById(id);
    }


}
