package com.josheytee.niheapp.user;

import com.josheytee.niheapp.app.AppCRUDServiceImpl;
import com.josheytee.niheapp.user.event.UserRegistrationEvent;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl extends AppCRUDServiceImpl<User> implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        User createdUser = super.create(user);
        if (createdUser != null)
            this.getEventPublisher().publishEvent(new UserRegistrationEvent(this, createdUser));

        return createdUser;
    }
}