package com.ecommerce.trendyol_clone.repository;

import com.ecommerce.trendyol_clone.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
