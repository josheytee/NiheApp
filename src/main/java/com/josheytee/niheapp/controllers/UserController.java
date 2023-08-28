package com.josheytee.niheapp.controllers;

import com.josheytee.niheapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/create")
//    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {
//        User user = new User();
//        BeanUtils.copyProperties(userRequest, user);
//        UserResponse userResponse = this.userService.create(user);
//        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update/{user_id}")
//    public ResponseEntity<UserResponse> updateStory(@PathVariable long user_id, @RequestBody UserRequest userRequest) {
//
//        UserResponse userResponse = userService.update(user_id, userRequest);
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