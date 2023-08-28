package com.josheytee.niheapp.services.impl;

import com.josheytee.niheapp.entities.User;
import com.josheytee.niheapp.repositories.UserRepository;
import com.josheytee.niheapp.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl extends BaseCRUDServiceImpl<User> implements UserService {

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }
}