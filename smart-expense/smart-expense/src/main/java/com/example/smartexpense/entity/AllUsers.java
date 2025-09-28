package com.example.smartexpense.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AllUsers {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long userId;
    private String username;
    private String email;
    
    

}
