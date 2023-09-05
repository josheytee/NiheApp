package com.josheytee.niheapp.story;

import com.josheytee.niheapp.app.AppRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedStoryRepository extends AppRepository<SharedStory, Long> {

}