package com.josheytee.niheapp.repositories;

import com.josheytee.niheapp.entities.Story;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends BaseRepository<Story, Long> {
}