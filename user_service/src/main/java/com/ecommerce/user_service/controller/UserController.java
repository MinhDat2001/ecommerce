package com.ecommerce.user_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.user_service.entity.UserEntity;
import com.ecommerce.user_service.dto.UserDTO;
import com.ecommerce.user_service.logging.AppLogger;
@RestController
public class UserController {

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserDTO registerDto){
        try{
            AppLogger.info("Register start");
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
