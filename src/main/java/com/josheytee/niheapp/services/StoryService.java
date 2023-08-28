package com.josheytee.niheapp.services;

import com.josheytee.niheapp.entities.Story;
import com.josheytee.niheapp.response.dto.StoryDTO;

import java.util.List;

public interface StoryService extends BaseCRUDService<Story> {
    public List<StoryDTO> getUserStories(long userid);

}