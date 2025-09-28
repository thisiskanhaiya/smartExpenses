package com.example.smartexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartexpense.entity.Budget;

public interface  BudgetRepo extends JpaRepository<Budget, Long> {

}
