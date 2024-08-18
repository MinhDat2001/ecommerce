package com.ecommerce.user_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.user_service.service.UserService;
import com.ecommerce.user_service.entity.UserEntity;
import com.ecommerce.user_service.dto.UserDTO;
import com.ecommerce.user_service.logging.AppLogger;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDTO userDTO) {
        AppLogger.info("createUser start: " + userDTO.toString());
        UserEntity createdUser = userService.createUser(userDTO);
        AppLogger.info("createUser successful");
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        AppLogger.info("updateUser start: " + userDTO.toString());
        UserEntity updatedUser = userService.updateUser(id, userDTO);
        AppLogger.info("updateUser successful");
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable Integer id) {
        AppLogger.info("getUser start: ");
        AppLogger.info("userID: " + id);
        UserEntity user = userService.getUser(id);
        AppLogger.info("getUser successful");
        return ResponseEntity.ok(user);
    }

    @GetMapping()
    public ResponseEntity<List<UserEntity>> getUsers() {
        AppLogger.info("getUsers start: ");
        List<UserEntity> users = userService.getUsers();
        AppLogger.info("getUsers successful");
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        AppLogger.info("deleteUser start: ");
        AppLogger.info("userID: " + id);
        userService.deleteUser(id);
        AppLogger.info("deleteUser successful");
        return ResponseEntity.noContent().build();
    }
}

