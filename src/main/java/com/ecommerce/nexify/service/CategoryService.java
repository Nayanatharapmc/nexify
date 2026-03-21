package com.ecommerce.nexify.service;

import com.ecommerce.nexify.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(String categoryId);
    Category updateCategory(Category category, String categoryId);
}
