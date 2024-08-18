package com.ecommerce.user_service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users", indexes = {
        @Index(name = "idx_username", columnList = "username")
})
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String firstName;
    private String username;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private String profilePicture;
}
