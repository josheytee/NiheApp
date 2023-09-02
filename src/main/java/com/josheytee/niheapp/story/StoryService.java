package com.josheytee.niheapp.story;

import com.josheytee.niheapp.app.AppCRUDService;
import com.josheytee.niheapp.story.Story;
import com.josheytee.niheapp.story.StoryDTO;

import java.util.List;

public interface StoryService extends AppCRUDService<Story> {
    public List<StoryDTO> getUserStories(long userid);

}