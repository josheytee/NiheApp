package com.josheytee.niheapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String phone;
    private String state;
    private String country;
    private String address;

    //    ArrayList<User> friends;
//    @OneToMany(mappedBy ="user", cascade = CascadeType.ALL)
//    private ArrayList<Comment> comments;
}