package com.josheytee.niheapp.story;

import com.josheytee.niheapp.app.AppCRUDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SharedStoryServiceImpl extends AppCRUDServiceImpl<SharedStory> implements SharedStoryService{
    public SharedStoryServiceImpl(SharedStoryRepository sharedStoryRepository) {
        super(sharedStoryRepository);
    }
}