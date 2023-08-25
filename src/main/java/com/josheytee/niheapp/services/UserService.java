package com.josheytee.niheapp.services;

import com.josheytee.niheapp.dto.requests.UserRequest;
import com.josheytee.niheapp.entities.User;
import com.josheytee.niheapp.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    public UserResponse create(User user);

    public List<UserResponse> all(long userid);

    public UserResponse update(long user_id, UserRequest userRequest);

    public UserResponse get(long id);

    public UserResponse delete(long id);
}
