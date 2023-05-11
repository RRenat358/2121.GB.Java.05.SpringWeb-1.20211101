package ru.rrenat358.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;

    private Double price;

    private String comment;
    private String tag;


}
