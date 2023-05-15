package ru.rrenat358.service;

import org.springframework.stereotype.Service;
import ru.rrenat358.entities.Product;
import ru.rrenat358.exceptions.ResourceNotFoundException;
import ru.rrenat358.repositories.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

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

    @Transactional
    public void changePrice(Long productId, Integer delta) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Продукт не найден для ID : " + productId));
        product.setPrice(product.getPrice() + delta);
    }


    public List<Product> findAllByPriceBetween(Integer min, Integer max) {
        return productRepository.findAllByPriceBetween(min, max);
    }

    public List<Product> findAllByPriceBelowLimit(Integer maxLimit) {
        return productRepository.findAllByPriceBelowLimit(maxLimit);
    }

    public List<Product> findAllByPriceAboveLimit(Integer minLimit) {
        return productRepository.findAllByPriceAboveLimit(minLimit);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

}
