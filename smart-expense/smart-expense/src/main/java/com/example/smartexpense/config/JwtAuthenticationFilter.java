package com.example.smartexpense.config;

import java.io.IOException;
import java.util.Collections;

import org.springframework.stereotype.Component;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.smartexpense.entity.AllUsers;
import com.example.smartexpense.repository.AllUsersRepo;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final AllUsersRepo allUsersRepo;

    public JwtAuthenticationFilter(JwtUtil jwtUtil, AllUsersRepo allUsersRepo) {
        this.jwtUtil = jwtUtil;
        this.allUsersRepo = allUsersRepo;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            try {
                String username = jwtUtil.extractUsername(token);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    var userOpt = allUsersRepo.findByUsername(username);
                    if (userOpt.isPresent()) {
                        AllUsers appUser = userOpt.get();
                        // build a UserDetails for validation
                        UserDetails userDetails = User.withUsername(appUser.getUsername())
                                                      .password(appUser.getPassword())
                                                      .authorities(Collections.emptyList())
                                                      .build();
                        if (jwtUtil.validateToken(token, userDetails)) {
                            UsernamePasswordAuthenticationToken auth =
                                    new UsernamePasswordAuthenticationToken(appUser, null, userDetails.getAuthorities());
                            SecurityContextHolder.getContext().setAuthentication(auth);
                        }
                    }
                }
            } catch (Exception ex) {
                // invalid token or other error -> do not authenticate
            }
        }

        filterChain.doFilter(request, response);
    }
}