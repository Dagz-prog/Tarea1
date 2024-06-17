package com.project.demo.logic.entity.category;

import com.project.demo.logic.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.name = ?1")
    Optional<Category> findByName(String name);

    @Query("select c from Category  c where c.id = ?1")
    Optional<Category> findById(Long id);



    @Query("select c From Category c WHERE LOWER(c.name) LIKE %?1% ")
    List<Category> findCategoriesWithCharacterInName(String character);
}
