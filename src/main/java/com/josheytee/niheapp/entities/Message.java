package com.josheytee.niheapp.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message extends BaseEntity {
    String firstname;
    String lastname;
    String username;
    String email;
    String phone;
    String state;
    String country;
    String address;
    
//    ArrayList<Message> friends;
//    ArrayList<Comment> comments;
}
