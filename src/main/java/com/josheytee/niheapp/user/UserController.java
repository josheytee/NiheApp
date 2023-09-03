package com.josheytee.niheapp.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final FriendRepository friendRepository;

    public UserController(UserService userService, FriendRepository friendRepository) {
        this.userService = userService;
        this.friendRepository = friendRepository;
    }

    @PostMapping("/friends")
    public ResponseEntity<Friend> addFriends(@RequestBody FriendRequest friendRequest,
                                             @AuthenticationPrincipal User user) {

        User friend = this.userService.get(friendRequest.getUser());
        Friend friend1 = friendRequest.toFriend(user, friend);
        Friend save = this.friendRepository.save(friend1);

        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    //
//    @PutMapping("/update/{Userid}")
//    public ResponseEntity<UserResponse> updateStory(@PathVariable long Userid, @RequestBody UserRequest userRequest) {
//
//        UserResponse userResponse = userService.update(Userid, userRequest);
//        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
//    }
//
    @GetMapping("/friends")
    public ResponseEntity<UserResponse> getFriends(@AuthenticationPrincipal User user) {

        UserResponse userResponse = UserResponse.builder()
                .code(200)
                .message("Friends fetched tipe tipe")
                .data(user.getFriends())
                .build();
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<UserResponse> delete(@PathVariable("id") long id) throws Exception {
//        UserResponse userResponse = userService.delete(id);
//        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
//    }

}