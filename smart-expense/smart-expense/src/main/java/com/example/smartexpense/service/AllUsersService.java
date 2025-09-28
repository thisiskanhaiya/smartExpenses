package com.example.smartexpense.service;

import java.util.List;

import com.example.smartexpense.entity.AllUsers;

public interface AllUsersService  {

    public void save(AllUsers user);

    public List<AllUsers> findAll();

}
