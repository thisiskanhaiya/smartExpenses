package com.example.smartexpense.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.smartexpense.entity.AllUsers;

@Repository
public interface AllUsersRepo extends JpaRepository<AllUsers, Long> {
    Optional<AllUsers> findByUsername(String username);
}
