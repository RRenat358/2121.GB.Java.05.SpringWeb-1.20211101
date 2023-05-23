package ru.rrenat358.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.rrenat358.entities.Product;

public interface ProductsRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Modifying
    @Query("UPDATE Product p SET p.price = p.price + ?2 WHERE p.id = ?1")
    void changePriceToDelta(Long id, Integer price);

    @Modifying
    @Query("UPDATE Product p SET p.price = ?2 WHERE p.id = ?1")
    void changePrice(Long id, Integer newPrice);

}
