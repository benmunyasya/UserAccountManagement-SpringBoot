package com.ben.useraccountmanagement.dto;

import com.ben.useraccountmanagement.validation.UniqueEmail;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class UserRequestDto {

    @NotBlank
    @Size(max = 100)
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @UniqueEmail
    private String email;

    @Size(max = 20)
    private String phone;

    // getters and setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
