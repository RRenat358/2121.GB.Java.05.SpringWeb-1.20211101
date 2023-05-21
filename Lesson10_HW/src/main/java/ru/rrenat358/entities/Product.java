package ru.rrenat358.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;


    @Column(name = "price")
    Integer price;



    @Column(name = "proteins")
    String proteins;

    @Column(name = "fats")
    String fats;

    @Column(name = "carbohydrates")
    String carbohydrates;

    @Column(name = "calories")
    String calories;

    @Column(name = "group_product")
    String groupProduct;



    //ProductDto


    public Product(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
