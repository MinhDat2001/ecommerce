package com.ecommerce.user_service.service;

import com.ecommerce.user_service.entity.UserEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.user_service.repository.UserRepository;
import com .ecommerce.user_service.dto.UserDTO;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public UserEntity createUser(UserDTO user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        return userRepo.save(userEntity);
    }

    public UserEntity updateUser(Integer id, UserDTO user) {
        return userRepo.findById(id).map(existingUser -> {
            BeanUtils.copyProperties(user, existingUser, "id");
            return userRepo.save(existingUser);
        }).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    public UserEntity getUser(Integer id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    public List<UserEntity> getUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(Integer id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new EntityNotFoundException("User not found with id " + id);
        }
    }
}
