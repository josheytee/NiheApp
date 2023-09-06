package com.josheytee.niheapp.user.event;

import com.josheytee.niheapp.user.User;
import org.springframework.context.ApplicationEvent;

public class UserRegistrationEvent extends ApplicationEvent {
    private User user;

    public UserRegistrationEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
    public User getUser(){
        return this.user;
    }

}