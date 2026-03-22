package com.ecommerce.nexify.service;

import com.ecommerce.nexify.model.Category;
import com.ecommerce.nexify.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CategoryServiceImpl implements CategoryService{

    private List<Category> categories = new ArrayList<>();
    private String uniqueId = UUID.randomUUID().toString();

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(uniqueId);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"Resource Not Found"));
        categoryRepository.delete(category);
        return "Category with categoryId: "+categoryId+" removed successfully.";
    }

    @Override
    public Category updateCategory(Category category, String categoryId) {
        Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);
        Category savedCategory = savedCategoryOptional.orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"Resource Not Found"));
        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;
    }
}
