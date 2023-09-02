package com.josheytee.niheapp.user;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> create(@RequestBody UserRequest userRequest) {
        User userBuilder = User.builder()
                .firstname(userRequest.getFirstname())
                .lastname(userRequest.getLastname())
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .phone(userRequest.getPhone())
                .address(userRequest.getAddress())
                .state(userRequest.getState())
                .country(userRequest.getCountry())
                .build();
        User user = this.userService.create(userBuilder);
        UserDTO userResponse = new UserDTO();
        BeanUtils.copyProperties(user, userResponse);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
//
//    @PutMapping("/update/{Userid}")
//    public ResponseEntity<UserResponse> updateStory(@PathVariable long Userid, @RequestBody UserRequest userRequest) {
//
//        UserResponse userResponse = userService.update(Userid, userRequest);
//        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserResponse> getStory(@PathVariable("id") long id) {
//        UserResponse userResponse = userService.get(id);
//        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<UserResponse> delete(@PathVariable("id") long id) throws Exception {
//        UserResponse userResponse = userService.delete(id);
//        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
//    }

}