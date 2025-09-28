package com.example.smartexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartexpense.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    
} 