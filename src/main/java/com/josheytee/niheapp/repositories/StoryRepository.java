package com.josheytee.niheapp.repositories;

import com.josheytee.niheapp.entities.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
}
