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

    public Expense(BigDecimal amount, Category category, LocalDate date, long expenseId, String note, AllUsers user) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.expenseId = expenseId;
        this.note = note;
        this.user = user;
    }

    public Expense() {
    }



    public long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(long expenseId) {
        this.expenseId = expenseId;
    }

    public AllUsers getUser() {
        return user;
    }

    public void setUser(AllUsers user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }



}
