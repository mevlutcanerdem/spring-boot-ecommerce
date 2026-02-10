package com.ecommerce.trendyol_clone.service;

import com.ecommerce.trendyol_clone.model.Category;
import com.ecommerce.trendyol_clone.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public Category createCatagory(Category category){
       return categoryRepository.save(category);
    }



}
