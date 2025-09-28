package com.example.smartexpense.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.smartexpense.entity.AllUsers;
import com.example.smartexpense.repository.AllUsersRepo;

@Service
public class AllUsersServiceImpl implements AllUsersService {

    private final AllUsersRepo allUsersRepo;
    AllUsersServiceImpl(AllUsersRepo allUsersRepo){
        this.allUsersRepo = allUsersRepo;
    }

    @Override
    public void save(AllUsers user) {
        allUsersRepo.save(user);
    }

    @Override
    public List<AllUsers> findAll() {
        return allUsersRepo.findAll();
    }

}
