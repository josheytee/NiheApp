package com.josheytee.niheapp.controllers;

import com.josheytee.niheapp.dto.response.StoryResponse;
import com.josheytee.niheapp.services.StoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/stories")
public class StoriesController {

    private final StoryService storyService;

    public StoriesController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping("/all/{userid}")
    public ResponseEntity<List<StoryResponse>> all(long userid) {
        List<StoryResponse> all = storyService.all(userid);
        return new ResponseEntity<List<StoryResponse>>(all, HttpStatus.CREATED);

    }
}
