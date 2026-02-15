package com.ecommerce.trendyol_clone.repository;

import com.ecommerce.trendyol_clone.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    // SELECT * FROM products WHERE category_id = ?
    List<Product> findByCategoryId(Long categoryId);

    // SELECT * FROM products WHERE name LIKE %keyword%
    List<Product> findByNameContaining(String keyword);
}
