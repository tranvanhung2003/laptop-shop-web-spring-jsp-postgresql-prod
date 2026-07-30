package com.tvhung.laptop_shop.domain;

import lombok.Data;

@Data
public class User {
    private long id;
    private String email;
    private String password;
    private String fullName;
    private String address;
    private String phoneNumber;
}
