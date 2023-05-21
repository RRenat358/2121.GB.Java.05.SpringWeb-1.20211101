package ru.rrenat358.converters;

import org.springframework.stereotype.Component;
import ru.rrenat358.dto.ProductDto;
import ru.rrenat358.entities.Product;

@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getName(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }


}
