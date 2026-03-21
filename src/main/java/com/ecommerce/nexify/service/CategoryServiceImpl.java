package com.ecommerce.nexify.service;

import com.ecommerce.nexify.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CategoryServiceImpl implements CategoryService{

    private List<Category> categories = new ArrayList<>();
    private String uniqueId = UUID.randomUUID().toString();

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(uniqueId);
        categories.add(category);
    }

    @Override
    public String deleteCategory(String categoryId) {
        Category category = categories.stream().filter(c -> c.getCategoryId().equals(categoryId)).findFirst().orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Category with categoryId: "+categoryId+" does not exist."));
        if (category==null){
            return "Category with categoryId: "+categoryId+" does not exist.";
        }
        categories.remove(category);
        return "Category with categoryId: "+categoryId+" removed successfully.";
    }

    @Override
    public Category updateCategory(Category category, String categoryId) {
        Optional<Category> optionalCategory = categories.stream().filter(c -> c.getCategoryId().equals(categoryId)).findFirst();
        if (optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
        } else {
            throw new ResponseStatusException(NOT_FOUND, "Category not found");
        }
    }
}
