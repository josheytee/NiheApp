package com.josheytee.niheapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity{
    String firstname;
    String lastname;
    String username;
    String email;
    String phone;
    String state;
    String country;
    String address;

//    ArrayList<User> friends;
//    ArrayList<Comment> comments;
}
