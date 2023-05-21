package ru.rrenat358.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.rrenat358.dto.ProductDto;
import ru.rrenat358.entities.Product;
import ru.rrenat358.exceptions.ResourceNotFoundException;
import ru.rrenat358.repositories.ProductRepository;
import ru.rrenat358.repositories.specifications.ProductSpecifications;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


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
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecifications.priceLessThanOrEqualsThan(maxPrice));
        }

        return productRepository.findAll(spec, pageRequest);
    }


    // NoUsed
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
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



    @Transactional
    public Product updateProduct(Product product) {
        Product productFind = productRepository.findById(product.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Продукт не найден для ID : " + product.getId()));
        productFind.setName(product.getName());
        productFind.setPrice(product.getPrice());
        //etc.
        productRepository.save(productFind);
        return productFind;
    }
    // OR
    @Transactional
    public Product updateProduct2(ProductDto productDto) {
        Product product = productRepository.findById(productDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Невозможно обновить продукта, не найден в базе, id: " + productDto.getId()));
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        return product;
    }




}
