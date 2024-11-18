package com.example.mrusnique.repository;
import com.example.mrusnique.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
