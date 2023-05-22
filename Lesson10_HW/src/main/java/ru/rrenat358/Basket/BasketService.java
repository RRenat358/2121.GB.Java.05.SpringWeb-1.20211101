package ru.rrenat358.Basket;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.rrenat358.dto.ProductDto;
import ru.rrenat358.entities.Product;
import ru.rrenat358.exceptions.ResourceNotFoundException;
import ru.rrenat358.repositories.ProductsRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BasketService {

    private final ProductsRepository productsRepository;
    private final Basket basket;


    public List<Product> basket() {
        return basket.basket();
    }


    public List<Product> addToBasket(Long id) {
        Product product = productsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Продукт не найден для ID : " + id));
        return basket.addToBasket(product);
    }


    public List<Product> clearBasket() {
        return basket.clearBasket();
    }





}
