package com.josheytee.niheapp.services;

import com.josheytee.niheapp.dto.response.StoryResponse;
import com.josheytee.niheapp.dto.requests.StoryRequest;
import com.josheytee.niheapp.entities.Story;

import java.util.List;

public interface StoryService {

    public StoryResponse create(Story story);

    public List<StoryResponse> all(long userid);

    public StoryResponse update(long story_id, StoryRequest storyRequest);

    public StoryResponse get(long story_id);

    public StoryResponse delete(long story_id) throws Exception;
}
