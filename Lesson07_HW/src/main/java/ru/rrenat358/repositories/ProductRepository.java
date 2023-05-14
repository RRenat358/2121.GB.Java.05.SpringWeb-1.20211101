package ru.rrenat358.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rrenat358.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {



}
