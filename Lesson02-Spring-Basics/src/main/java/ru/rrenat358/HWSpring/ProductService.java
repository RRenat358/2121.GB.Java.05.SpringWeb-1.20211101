package ru.rrenat358.HWSpring;


import org.springframework.stereotype.Component;

import java.util.TreeMap;

@Component
public class ProductService {


    private TreeMap<Integer, Product> productTreeMap = new TreeMap<>();


    public void addProduct(Integer id, Product product) {
        productTreeMap.put(id, product);
    }

    //forExample
    private void initForExample() {
        addProduct(1,new Product(1, "noName1"));
        addProduct(2,new Product(2, "noName2"));
        addProduct(3,new Product(3, "noName3"));
        addProduct(4,new Product(4, "noName4"));
        addProduct(5,new Product(5, "noName5"));
    }




}
