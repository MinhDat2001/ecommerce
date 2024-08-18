package com.ecommerce.authentication_service.controller;

import com.ecommerce.authentication_service.dto.LoginDTO;
import com.ecommerce.authentication_service.dto.RegisterDTO;
import com.ecommerce.authentication_service.entity.UserEntity;
import com.ecommerce.authentication_service.service.JwtService;
import com.ecommerce.authentication_service.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody RegisterDTO registerUser) {
        UserEntity userInfo = new UserEntity();
        BeanUtils.copyProperties(registerUser, userInfo);
        return service.addUser(userInfo);
    }

    @GetMapping("/user/userProfile")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody LoginDTO authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}
