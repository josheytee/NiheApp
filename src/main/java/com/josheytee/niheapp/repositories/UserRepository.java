package com.josheytee.niheapp.repositories;

import com.josheytee.niheapp.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
}