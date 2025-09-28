package com.example.smartexpense.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartexpense.entity.AllUsers;
import com.example.smartexpense.service.AllUsersService;

@RestController
@RequestMapping("/user")
public class AllUsersController {
    private final AllUsersService allUsersService;
    AllUsersController(AllUsersService allUsersService){
        this.allUsersService = allUsersService;
    }

   
    @GetMapping("/findall")
    public List<AllUsers> findAll(){
        return allUsersService.findAll();
    }


}
