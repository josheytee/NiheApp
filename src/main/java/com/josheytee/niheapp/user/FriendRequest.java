package com.josheytee.niheapp.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequest {

    private long user;
//    private Status status;


    public Friend toFriend(User user,User friend) {
        return Friend.builder()
                .user(user)
                .friend(friend)
                .status(Status.REQUESTED)
                .build();
    }
}