package com.josheytee.niheapp.reaction;

import com.josheytee.niheapp.app.AppRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends AppRepository<Reaction, Long> {
}