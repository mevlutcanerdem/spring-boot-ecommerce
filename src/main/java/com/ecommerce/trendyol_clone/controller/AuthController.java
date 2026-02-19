package com.ecommerce.trendyol_clone.controller;


import com.ecommerce.trendyol_clone.dto.RegisterRequest;
import com.ecommerce.trendyol_clone.model.User;
import com.ecommerce.trendyol_clone.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth") // what comes to this address exempt from security
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // we call the crypto method


    public AuthController(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
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

}
