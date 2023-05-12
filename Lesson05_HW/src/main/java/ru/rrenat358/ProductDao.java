package ru.rrenat358;


import java.util.List;

public interface ProductDao {

    List<Product> findAll();


    Product findById(Long id);

    Product findByName(String name);


    void save(Product product);

    void updateNameById(Long id, String newName);


    void deleteById(Long id);


    void testCaching();


}
