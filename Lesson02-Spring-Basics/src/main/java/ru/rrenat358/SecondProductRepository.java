package ru.rrenat358;

import org.springframework.stereotype.Component;

@Component
public class SecondProductRepository implements ProductRepository {
    @Override
    public Product findById(Long id) {
        throw new UnsupportedOperationException();
    }
}
