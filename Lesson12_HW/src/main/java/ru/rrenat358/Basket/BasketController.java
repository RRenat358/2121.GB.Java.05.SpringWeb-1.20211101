package ru.rrenat358.Basket;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rrenat358.converters.ProductConverter;
import ru.rrenat358.dto.ProductDto;
import ru.rrenat358.entities.Product;

import java.util.List;

@RestController
@RequestMapping("/api/v1/baskets")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;
    private final ProductConverter productConverter;


    @GetMapping("")
    public List<ProductDto> basket() {
        List<Product> productList = basketService.basket();
        return productConverter.entityToDtoList(productList);
    }

    @GetMapping("/add/{id}")
    public List<ProductDto> addToBasket(@PathVariable Long id) {
        List<Product> productList = basketService.addToBasket(id);
        return productConverter.entityToDtoList(productList);
    }

    @GetMapping("/remove/{id}")
    public List<ProductDto> removeFromBasket(@PathVariable Long id) {
        List<Product> productList = basketService.removeFromBasket(id);
        return productConverter.entityToDtoList(productList);
    }

    @GetMapping("/clear")
    public List<ProductDto> clearBasket() {
        List<Product> productList = basketService.clearBasket();
        return productConverter.entityToDtoList(productList);
    }


}
