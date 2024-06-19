package com.project.demo.rest.product;


import com.project.demo.logic.entity.category.Category;
import com.project.demo.logic.entity.category.CategoryRepository;
import com.project.demo.logic.entity.product.Product;
import com.project.demo.logic.entity.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductoRestController {

    @Autowired
    private ProductRepository ProductRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Product> findAllProducts() {return ProductRepository.findAll();}

    @GetMapping("/filterByName/{name}")
    public List<Product> getProductByName(@PathVariable String name) {
        return ProductRepository.findProductsWithCharacter(name);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        Optional<Product> actualProduct = ProductRepository.findByName(product.getName());
        if (actualProduct.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product already registered.");
        }
        Optional<Category> optionalCategory = categoryRepository.findByName(product.getCategory().getName());

        if (optionalCategory.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Category does not exist.");
        }
        product.setCategory(optionalCategory.get());
        Product savedProduct = ProductRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);

    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ProductRepository.findById(id)
                .map(actualProduct->{
            actualProduct.setName(product.getName());
            actualProduct.setDescription(product.getDescription());
            actualProduct.setPrice(product.getPrice());
            actualProduct.setCategory(product.getCategory());
            actualProduct.setQtyStock(product.getQtyStock());


            return ProductRepository.save(actualProduct);
        })
                .orElseGet(()->{
                    product.setId(id);
                    return ProductRepository.save(product);
                });
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public void deleteProduct(@PathVariable Long id) {
        ProductRepository.deleteById(id);
    }


}

