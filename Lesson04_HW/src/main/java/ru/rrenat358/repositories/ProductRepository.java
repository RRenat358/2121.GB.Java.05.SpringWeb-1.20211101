package ru.rrenat358.repositories;


import org.springframework.stereotype.Repository;
import ru.rrenat358.entities.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {

    List<Product> products;


    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Яблоки", 20.99, "Красные", "Фрукты",20),
                new Product(2L, "Бананы", 50.80, "Эквадор", "Фрукты", 20),
                new Product(3L, "Груши", 33.50, "Лесная красавица", "Фрукты", 20),
                new Product(4L, "Сливы", 40.00, "Синие, чернослив", "Фрукты", 20),
                new Product(5L, "Морковь", 15.00, "Воронежская", "Овощи", 20)
        ));
    }


    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }


    public Product findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("-= Продукт не найден =-"));
    }


    public void deleteById(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }






}
