package com.ecommerce.nexify.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity (name = "Categories") // Converts the java class to a JPA entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id  // Defines the primary key
    // @GeneratedValue(strategy = GenerationType.IDENTITY) // Manages the generated value of the primary key
    private String categoryId;
    private String categoryName;
}
