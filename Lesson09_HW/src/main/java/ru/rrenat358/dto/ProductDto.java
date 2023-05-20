package ru.rrenat358.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rrenat358.entities.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    Long id;
    String name;
    Integer price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }


}
