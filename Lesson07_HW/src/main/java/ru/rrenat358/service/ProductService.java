package ru.rrenat358.service;

import org.springframework.stereotype.Service;
import ru.rrenat358.entities.Product;
import ru.rrenat358.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void changePrice() {
        //***
    }


}
