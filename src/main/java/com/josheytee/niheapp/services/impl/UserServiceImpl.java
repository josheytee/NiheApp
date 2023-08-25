package com.josheytee.niheapp.services.impl;

import com.josheytee.niheapp.dto.requests.UserRequest;
import com.josheytee.niheapp.dto.response.StoryResponse;
import com.josheytee.niheapp.dto.response.UserResponse;
import com.josheytee.niheapp.entities.User;
import com.josheytee.niheapp.services.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public UserResponse create(User user) {
        return null;
    }

    @Override
    public List<UserResponse> all(long user_id) {
        return null;
    }

    @Override
    public UserResponse update(long user_id, UserRequest userRequest) {
        return null;
    }

    @Override
    public UserResponse get(long id) {
        return null;
    }

    @Override
    public UserResponse delete(long id) {
        return null;
    }
}
