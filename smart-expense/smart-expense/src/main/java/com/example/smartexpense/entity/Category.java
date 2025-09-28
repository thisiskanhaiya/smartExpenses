package com.example.smartexpense.entity;

import java.util.List;

import jakarta.annotation.Generated;
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

}
