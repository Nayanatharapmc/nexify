package com.ecommerce.nexify.repositories;

import com.ecommerce.nexify.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// Creates a repository interface for Category  object and extend it with JPA repository. Arguments are the JPA object name and the primary key data type
public interface CategoryRepository extends JpaRepository<Category,String>{
}
