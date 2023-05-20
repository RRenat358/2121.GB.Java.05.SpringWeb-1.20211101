package ru.rrenat358.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.rrenat358.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findAllByPriceBetween(Integer min, Integer max);


    //@Query("SELECT p FROM Product p WHERE p.price < 20")
    @Query("SELECT p FROM Product p WHERE p.price < ?1")
    List<Product> findAllByPriceBelowLimit(Integer maxLimit);

    //@Query("SELECT p FROM Product p WHERE p.price > 80")
    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> findAllByPriceAboveLimit(Integer minLimit);

    @Modifying
    @Query("UPDATE Product p SET p.price = p.price + ?2 WHERE p.id = ?1")
    void changePriceToDelta(Long id, Integer price);

    @Modifying
    @Query("UPDATE Product p SET p.price = ?2 WHERE p.id = ?1")
    void changePrice(Long id, Integer newPrice);


}
