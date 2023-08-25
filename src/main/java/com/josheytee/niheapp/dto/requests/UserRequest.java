package com.josheytee.niheapp.dto.requests;

import lombok.Builder;
import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
import com.josheytee.niheapp.entities.User;

@Data
@Builder
public class UserRequest {
    String firstname;
    String lastname;
    String username;
    String email;
    String phone;
    String state;
    String country;
    String address;

    private List<User> friends;

    @OneToMany(targetEntity = User.class, mappedBy = "user", cascade = CascadeType.ALL)
    public List<User> getFriends() {
        return this.friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
