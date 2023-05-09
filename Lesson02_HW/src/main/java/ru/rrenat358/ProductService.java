package ru.rrenat358;

import org.springframework.stereotype.Component;

@Component
public class ProductService {

    private ProductRepository productRepository;

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
