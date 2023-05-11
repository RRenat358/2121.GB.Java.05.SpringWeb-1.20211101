package ru.rrenat358.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.rrenat358.entity.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;


    @PostConstruct
    private void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Яблоки"),
                new Product(2L, "Бананы"),
                new Product(3L, "Груши"),
                new Product(4L, "Сливы"),
                new Product(5L, "Морковь")
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


    public void removeById(Long id) {
//        products.remove(id); //не верно, т.к. в Коллекции может оказать >1 с одинаковым ID
        products.removeIf(product -> product.getId().equals(id));
    }


}
