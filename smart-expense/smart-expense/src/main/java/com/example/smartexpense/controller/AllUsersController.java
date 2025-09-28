package com.example.smartexpense.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartexpense.entity.AllUsers;
import com.example.smartexpense.repository.AllUsersRepo;
import com.example.smartexpense.service.AllUsersService;

@RestController
@RequestMapping("/user")
public class AllUsersController {
    private final AllUsersService allUsersService;
    AllUsersController(AllUsersService allUsersService){
        this.allUsersService = allUsersService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody AllUsers user){
        allUsersService.save(user);
        return "User registered Successfully";
    }
    @GetMapping("/findall")
    public List<AllUsers> findAll(){
        return allUsersService.findAll();
    }


}
