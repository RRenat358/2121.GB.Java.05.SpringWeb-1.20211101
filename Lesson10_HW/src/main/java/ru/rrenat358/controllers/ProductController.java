package ru.rrenat358.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.converters.ProductConverter;
import ru.rrenat358.dto.ProductDto;
import ru.rrenat358.entities.Product;
import ru.rrenat358.exceptions.ResourceNotFoundException;
import ru.rrenat358.service.ProductService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    final ProductService productService;
    final ProductConverter productConverter;


    //============================================================
    // GET

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
                .map(product -> productConverter.entityToDto(product));
    }


    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        Product product = productService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Продукт не найден для ID : " + id));
        return productConverter.entityToDto(product);
    }


    //============================================================
    // POST

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        Product product = productConverter.dtoToEntity(productDto);
        product = productService.saveProduct(product);
        return productConverter.entityToDto(product);
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

//    @PutMapping
//    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
//        Optional<Product> product = productService.findById(productDto.getId());
//        if (product.isPresent()) {
//            product.get().setName(productDto.getName());
//            product.get().setPrice(productDto.getPrice());
//            Product product2 = productService.saveProduct(product.get());
//            return new ProductDto(product2);
//        }
//        return null;
//    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Product product = productConverter.dtoToEntity(productDto);
        product = productService.updateProduct(product);
        return productConverter.entityToDto(product);
    }
    // OR
//    @PutMapping
//    public ProductDto updateProduct2(@RequestBody ProductDto productDto) {
//        productValidator.validate(productDto);
//        Product product = productsService.update(productDto);
//        return productConverter.entityToDto(product);
//    }


    //============================================================
    // DELETE
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }


}
