package ru.rrenat358.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rrenat358.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetween(Integer min, Integer max);


}
