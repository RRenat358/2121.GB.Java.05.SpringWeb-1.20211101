package ru.rrenat358.converters;

import org.springframework.stereotype.Component;
import ru.rrenat358.dto.ProductDto;
import ru.rrenat358.entities.Product;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {

    //============================================================
    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getName(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }

    //============================================================
    public List<Product> dtoToEntityList(List<ProductDto> productDtoList) {
        List<Product> productList = productDtoList
                .stream()
                .map(productDto -> {
                    Product product = new Product();
                    product.setId(productDto.getId());
                    product.setName(productDto.getName());
                    product.setPrice(productDto.getPrice());
                    return product;
                })
                .collect(Collectors.toList());
        return productList;
    }

    public List<ProductDto> entityToDtoList(List<Product> productList) {
        List<ProductDto> productDtoList = productList
                .stream()
                .map(product -> {
                    ProductDto productDto = new ProductDto();
                    productDto.setId(product.getId());
                    productDto.setName(product.getName());
                    productDto.setPrice(product.getPrice());
                    return productDto;
                })
                .collect(Collectors.toList());
        return productDtoList;
    }

    //============================================================


}
