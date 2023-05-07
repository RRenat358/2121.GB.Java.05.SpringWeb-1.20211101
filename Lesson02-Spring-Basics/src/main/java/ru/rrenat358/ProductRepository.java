package ru.rrenat358;

import org.springframework.stereotype.Component;

@Component
public interface ProductRepository {
    Product findById(Long id);
}
