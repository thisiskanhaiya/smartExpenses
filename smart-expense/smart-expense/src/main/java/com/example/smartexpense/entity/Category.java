package com.example.smartexpense.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long categoryId;
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private List<Expense> expenses;

    public Category(long categoryId, List<Expense> expenses) {
        this.categoryId = categoryId;
        this.expenses = expenses;
    }

    public Category() {
    }


    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
