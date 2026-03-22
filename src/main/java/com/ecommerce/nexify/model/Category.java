package com.ecommerce.nexify.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity (name = "Categories") // Converts the java class to a JPA entity
public class Category {
    @Id  // Defines the primary key
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Manages the generated value of the primary key
    private String categoryId;
    private String categoryName;

    public Category(){}

    public Category(String categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
