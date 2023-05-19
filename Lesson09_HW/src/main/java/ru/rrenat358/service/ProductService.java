package ru.rrenat358.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.rrenat358.entities.Product;
import ru.rrenat358.repositories.ProductRepository;
import ru.rrenat358.repositories.specifications.ProductSpecifications;

import javax.persistence.criteria.CriteriaBuilder;
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
            Integer minPrice, Integer maxPrice,
            String namePart
    ) {
        PageRequest pageRequest = PageRequest.of(page - 1, 3);
        Specification<Product> spec = Specification.where(null);

        if (minPrice != null) {
            spec = spec.and(ProductSpecifications.scoreGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecifications.scoreLessThanOrEqualsThan(maxPrice));
        }
        if (namePart != null) {
            spec = spec.and(ProductSpecifications.nameLike(namePart));
        }


        return productRepository.findAll(spec, pageRequest);
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

    // NoUsed
//    @Transactional
//    public void changePrice(Long productId, Integer delta) {
//        Product product = productRepository.findById(productId)
//                .orElseThrow(()-> new ResourceNotFoundException("Продукт не найден для ID : " + productId));
//        product.setPrice(product.getPrice() + delta);
//    }

    @Transactional
    public void changePriceToDelta(Long id, Integer delta) {
        productRepository.changePriceToDelta(id, delta);
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
