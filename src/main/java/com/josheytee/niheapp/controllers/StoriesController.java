package com.josheytee.niheapp.controllers;

import com.josheytee.niheapp.response.BaseResponse;
import com.josheytee.niheapp.response.dto.StoryDTO;
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
    public ResponseEntity<BaseResponse<List<StoryDTO>>> all(long userid) {
        List<StoryDTO> userStories = storyService.getUserStories(userid);
        BaseResponse<List<StoryDTO>> listBaseResponse = new BaseResponse<>();
        listBaseResponse.setData(userStories);
        listBaseResponse.setMessage("Successfully Fetched user stories");
        listBaseResponse.setCode(201);
        return new ResponseEntity<>(listBaseResponse, HttpStatus.CREATED);

    }
}
