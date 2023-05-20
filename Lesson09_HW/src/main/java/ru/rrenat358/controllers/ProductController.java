package ru.rrenat358.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.dto.ProductDto;
import ru.rrenat358.entities.Product;
import ru.rrenat358.service.ProductService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {


    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // NoUsed
//    @GetMapping("")
//    public List<Product> findAll() {
//        return productService.findAll();
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
        return productService.findByFilter(page, namePart, minPrice, maxPrice)
                .map(product -> new ProductDto(product));
    }


    @GetMapping("/{id}")
    public Optional<ProductDto> findById(@PathVariable Long id) {
        return productService.findById(id).map(product -> new ProductDto(product));
    }


    //============================================================
    // POST
//    @PostMapping("")
//    @PostMapping
//    public Product saveNewProduct(@RequestBody Product product) {
//        product.setId(null); //на всякий случай
//        return productService.saveProduct(product);
//    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        productDto.setId(null); //на всякий случай
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        Product product2 = productService.saveProduct(product);
        return new ProductDto(product2);
    }

    //============================================================
    // PATCH
    @PatchMapping("/change-price-to-delta")
    public void changePriceToDelta(@RequestParam Long id, @RequestParam Integer delta) {
        productService.changePriceToDelta(id, delta);
    }

    // NoUsed
    @PatchMapping("/change-price")
    public void changePrice(@RequestParam Long id, @RequestParam Integer newPrice) {
        productService.changePrice(id, newPrice);
    }

    //============================================================
    // PUT

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Optional<Product> product = productService.findById(productDto.getId());
        if (product.isPresent()) {
            product.get().setName(productDto.getName());
            product.get().setPrice(productDto.getPrice());
            Product product2 = productService.saveProduct(product.get());
            return new ProductDto(product2);
        }
        return null;
    }

    //============================================================
    // DELETE
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }


    //============================================================
    // ФИЛЬТЫ

/*
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

*/


}
