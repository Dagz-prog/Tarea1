package com.project.demo.rest.category;


import com.project.demo.logic.entity.category.Category;
import com.project.demo.logic.entity.category.CategoryRepository;
import com.project.demo.logic.entity.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {

    @Autowired
    private CategoryRepository CategoryRepository;

    @GetMapping
    public List<Category> getAllCategories() {
        return CategoryRepository.findAll();
    }

    @GetMapping("/filterByName/{name}")
    public List<Category> findCategoryByName(@PathVariable String name) {
        return CategoryRepository.findCategoriesWithCharacterInName(name);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Category saveCategory(@RequestBody Category category) {
        return CategoryRepository.save(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable long id, @RequestBody Category category) {

        return CategoryRepository.findById(id)
                .map(actualCat ->{
                    actualCat.setName(category.getName());
                    actualCat.setDescription(category.getDescription());
                    return CategoryRepository.save(actualCat);
                })
                .orElseGet(()->{
                    category.setId(id);
                    return CategoryRepository.save(category);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable long id) {
        CategoryRepository.deleteById(id);
    }

}
