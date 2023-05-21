package ru.rrenat358.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.rrenat358.entities.Product;
import ru.rrenat358.exceptions.ResourceNotFoundException;
import ru.rrenat358.repositories.ProductRepository;
import ru.rrenat358.repositories.specifications.ProductSpecifications;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Page<Product> findByFilter(
            Integer page,
            String namePart,
            Integer minPrice, Integer maxPrice
    ) {
        PageRequest pageRequest = PageRequest.of(page - 1, 5);
        Specification<Product> spec = Specification.where(null);

        if (namePart != null) {
            spec = spec.and(ProductSpecifications.nameLike(namePart));
        }
        if (minPrice != null) {
            spec = spec.and(ProductSpecifications.scoreGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecifications.scoreLessThanOrEqualsThan(maxPrice));
        }

        return productRepository.findAll(spec, pageRequest);
    }


    // NoUsed
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Продукт не найден для ID : " + id)));
    }

    @Transactional
    public void changePriceToDelta(Long id, Integer delta) {
        productRepository.changePriceToDelta(id, delta);
    }

    // NoUsed
    @Transactional
    public void changePrice(Long id, Integer newPrice) {
        productRepository.changePrice(id, newPrice);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }



}
