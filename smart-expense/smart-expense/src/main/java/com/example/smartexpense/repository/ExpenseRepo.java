package com.example.smartexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartexpense.entity.Expense;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {

}
