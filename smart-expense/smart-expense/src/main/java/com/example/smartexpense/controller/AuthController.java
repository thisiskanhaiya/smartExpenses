package com.example.smartexpense.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartexpense.config.JwtUtil;
import com.example.smartexpense.entity.AllUsers;
import com.example.smartexpense.repository.AllUsersRepo;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AllUsersRepo repo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
     private final JwtUtil jwtUtil;
    public AuthController(AllUsersRepo repo, PasswordEncoder encoder, AuthenticationManager authManager,JwtUtil jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.authManager = authManager;
       this.jwtUtil = jwtUtil; // 
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        if (repo.findByUsername(req.username).isPresent()) {
            return ResponseEntity.badRequest().body("username already exists");
        }
        AllUsers u = new AllUsers();
        u.setUsername(req.username);
        u.setEmail(req.email);
        u.setPassword(encoder.encode(req.password));
        var saved = repo.save(u);
        return ResponseEntity.ok(saved.getUserId());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        Authentication authentication = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(req.username, req.password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
     var principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        String token = jwtUtil.generateToken(principal);
        return ResponseEntity.ok(new AuthResponse("Bearer " + token));
   }

    public static class RegisterRequest { public String username; public String email; public String password; }
    public static class LoginRequest { public String username; public String password; }

    public static class AuthResponse {
        private String token;

        public AuthResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}