package ru.rrenat358.HWSpring;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Product {

    private Integer id;

    private String name;

    private Double price;


    public Product() {
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
