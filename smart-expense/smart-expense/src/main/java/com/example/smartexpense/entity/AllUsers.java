package com.example.smartexpense.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AllUsers {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long userId;
    private String username;
    private String email;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Expense> expenses = new ArrayList<>();

    
    public AllUsers() {
    }

    

    public AllUsers(long userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }



    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

}
