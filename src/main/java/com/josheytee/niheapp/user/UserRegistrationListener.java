package com.josheytee.niheapp.user;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationListener implements ApplicationListener<UserRegistrationEvent> {
    @Override
    public void onApplicationEvent(UserRegistrationEvent event) {
        // ... handle event ...
        System.out.println(event+ "na me dey here oo");
    }
}