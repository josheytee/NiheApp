package com.josheytee.niheapp.user;

import com.josheytee.niheapp.story.Story;
import com.josheytee.niheapp.story.StoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final FriendRepository friendRepository;
    private final StoryRepository storyRepository;

    public UserController(UserService userService, FriendRepository friendRepository, StoryRepository storyRepository) {
        this.userService = userService;
        this.friendRepository = friendRepository;
        this.storyRepository = storyRepository;
    }

    @PostMapping("/friends")
    public ResponseEntity<Friend> addFriends(@RequestBody FriendRequest friendRequest,
                                             @AuthenticationPrincipal User user) {

        User friend = this.userService.get(friendRequest.getUser());
        Friend friend1 = friendRequest.toFriend(user, friend);
        Friend save = this.friendRepository.save(friend1);

        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }


    @GetMapping("/friends")
    public ResponseEntity<UserResponse> getFriends(@AuthenticationPrincipal User user) {

        UserResponse userResponse = UserResponse.builder()
                .code(200)
                .message("Friends fetched tipe tipe")
                .data(user.getFriends())
                .build();
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }


    @GetMapping("/timeline")
    public ResponseEntity<UserResponse> updateStory(@AuthenticationPrincipal User user) {
        List<Friend> friends = user.getFriends();
        List<Long> allIdsFromUser = friendRepository.getAllIdsFromUser(user);
        List<Story> allFromFriendsId = storyRepository.getAllFromFriendsId(allIdsFromUser);


        UserResponse userResponse = UserResponse.builder()
                .data(allFromFriendsId)
                .message("oya na ")
                .code(200)
                .build();
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }
//
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<UserResponse> delete(@PathVariable("id") long id) throws Exception {
//        UserResponse userResponse = userService.delete(id);
//        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
//    }

}