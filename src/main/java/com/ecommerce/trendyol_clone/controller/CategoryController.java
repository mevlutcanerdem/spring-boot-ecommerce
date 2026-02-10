package com.ecommerce.trendyol_clone.controller;

import com.ecommerce.trendyol_clone.model.Category;
import com.ecommerce.trendyol_clone.repository.CategoryRepository;
import com.ecommerce.trendyol_clone.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCatagory(category);
    }
}
