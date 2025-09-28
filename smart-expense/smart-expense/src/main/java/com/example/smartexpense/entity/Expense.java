package com.example.smartexpense.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long expenseId;
    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="userId",nullable=false)
    private AllUsers user;
    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="categoryId",nullable=false)
    private Category category;
    private BigDecimal amount;
    private LocalDate date;
    private String note;

}
