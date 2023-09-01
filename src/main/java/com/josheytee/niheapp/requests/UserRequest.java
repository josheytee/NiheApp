package com.josheytee.niheapp.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    String firstname;
    String lastname;
    String username;
    String email;
    String phone;
    String state;
    String country;
    String address;

//    private List<User> friends;

//    @OneToMany(targetEntity = User.class, mappedBy = "user", cascade = CascadeType.ALL)
//    public List<User> getFriends() {
//        return this.friends;
//    }
//
//    public void setFriends(List<User> friends) {
//        this.friends = friends;
//    }
}