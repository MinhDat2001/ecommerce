package com.ecommerce.user_service.dto;
import lombok.Data;
@Data
public class UserDTO {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private String profilePicture;
}
