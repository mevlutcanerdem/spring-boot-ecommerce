package com.ecommerce.trendyol_clone.controller;


import com.ecommerce.trendyol_clone.dto.LoginRequest;
import com.ecommerce.trendyol_clone.dto.RegisterRequest;
import com.ecommerce.trendyol_clone.model.User;
import com.ecommerce.trendyol_clone.repository.UserRepository;
import com.ecommerce.trendyol_clone.service.CustomUserDetailsService;
import com.ecommerce.trendyol_clone.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;

@RestController
@RequestMapping("/api/auth") // what comes to this address exempt from security
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // we call the crypto method
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    // Constructor injection
    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          AuthenticationManager authenticationManager,
                          CustomUserDetailsService userDetailsService,
                          JwtUtil jwtUtil){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request){

        // check is there someone who has same username
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return "Error: This username already taken!";
        }

        User newUser = new User();
        newUser.setUsername(request.getUsername());


        String pass = passwordEncoder.encode(request.getPassword());
        newUser.setPassword(pass);

        newUser.setRole("USER");

        userRepository.save(newUser);

        return "Registration is succeed.Welcome!" + request.getUsername();

    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){

        // 1. step : we say authentication manager that check the password
        // if password wrong , spring throws an error

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
        );

        // 2.step : If password is true , get the detailed file of user from database

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        // 3.step : it works the JwtUtil factory and produce a token for customer

        String jwtToken = jwtUtil.generateToken(userDetails.getUsername());

        // 4.step :  it throws token to the customer
        return jwtToken;




    }




}
