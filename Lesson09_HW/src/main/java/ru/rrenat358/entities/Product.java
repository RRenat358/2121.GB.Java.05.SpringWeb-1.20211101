package ru.rrenat358.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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



}
