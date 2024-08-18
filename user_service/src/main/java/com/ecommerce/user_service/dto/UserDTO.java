package com.ecommerce.user_service.dto;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDTO {
    private String firstName;
    private String username;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private String profilePicture;
}
