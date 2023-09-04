package com.josheytee.niheapp.user;

import com.josheytee.niheapp.app.AppRepository;

import java.util.Optional;

public interface UserRepository extends AppRepository<User, Long> {

  Optional<User> findByEmail(String email);

}