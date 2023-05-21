package com.trantuyen.springecommerce.models;

import lombok.Data;

@Data
public class RegisterModel {
    private String username;
    private String password;
    private String passwordConfirm;
    private String fullName;
    private String phone;
    private String email;
}
