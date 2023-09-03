package com.josheytee.niheapp.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String phone;
    private String state;
    private String country;
    private String address;

//    private List<User> friends;

    public User toUser() {
        return User.builder()
                .firstname(this.getFirstname())
                .lastname(this.getLastname())
                .username(this.getUsername())
                .email(this.getEmail())
                .phone(this.getPhone())
                .address(this.getAddress())
                .state(this.getState())
                .country(this.getCountry())
                .build();
    }
}