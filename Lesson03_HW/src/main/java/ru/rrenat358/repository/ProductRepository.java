package ru.rrenat358.repository;

import org.springframework.stereotype.Component;
import ru.rrenat358.entity.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;


    @PostConstruct
    private void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Яблоки"),
                new Product(2L, "Бананы"),
                new Product(3L, "Груши"),
                new Product(4L, "Сливы"),
                new Product(5L, "Мороковь")
        ));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(product -> products.equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException());
    }

    public void removeById(Long id) {
        products.remove(id);
    }


}
