package com.josheytee.niheapp.user.auth;

import com.josheytee.niheapp.user.Role;
import com.josheytee.niheapp.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private String username;
  private String phone;
  private String state;
  private String country;
  private String address;
  private Role role;

  public User toUser(PasswordEncoder passwordEncoder) {
    return User.builder()
            .firstname(this.getFirstname())
            .lastname(this.getLastname())
            .username(this.getUsername())
            .email(this.getEmail())
            .password(passwordEncoder.encode(this.getPassword()))
            .phone(this.getPhone())
            .address(this.getAddress())
            .state(this.getState())
            .country(this.getCountry())
            .role(this.getRole())
            .build();
  }
}