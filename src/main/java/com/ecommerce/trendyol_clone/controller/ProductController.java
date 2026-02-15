package com.ecommerce.trendyol_clone.controller;


import com.ecommerce.trendyol_clone.model.Product;
import com.ecommerce.trendyol_clone.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct( @PathVariable Long id,@Valid @RequestBody Product newProduct){
         return productService.updateProduct(id,newProduct);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Product deleted successfully.ID: " + id;
    }


    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable Long categoryId){
        return productService.getProductsByCategory(categoryId);
    }

    // URL example : /api/products/search?name= Laptop
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name){
        return productService.searchProducts(name);
    }
}
