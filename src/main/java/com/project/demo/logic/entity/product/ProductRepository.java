package com.project.demo.logic.entity.product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE %?1% ")
    List<Product> findProductsWithCharacter(String name);

    @Query("select p from Product p where Lower(p.category) like %?1% ")
    List<Product> findProductsByCategory(String category);




    @Query("SELECT p FROM Product p WHERE p.name = ?1")
    Optional<Product> findByName(String name);
}
