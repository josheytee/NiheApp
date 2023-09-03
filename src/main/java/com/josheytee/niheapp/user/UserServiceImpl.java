package com.josheytee.niheapp.user;

import com.josheytee.niheapp.app.AppCRUDServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl extends AppCRUDServiceImpl<User> implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }
}