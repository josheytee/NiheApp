package com.josheytee.niheapp.controllers;

import com.josheytee.niheapp.dto.response.StoryResponse;
import com.josheytee.niheapp.dto.requests.StoryRequest;
import com.josheytee.niheapp.entities.Story;
import com.josheytee.niheapp.services.StoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/story")
@Controller
public class StoryController {

    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping("/create")
    public ResponseEntity<StoryResponse> create(@RequestBody StoryRequest storyRequest) {
        StoryResponse storyResponse = this.storyService.create(new Story(storyRequest.getTitle(), storyRequest.getContent()));
        return new ResponseEntity<StoryResponse>(storyResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{story_id}")
    public ResponseEntity<StoryResponse> updateStory(@PathVariable long story_id, @RequestBody StoryRequest storyRequest) {

        StoryResponse storyResponse = storyService.update(story_id, storyRequest);
        return new ResponseEntity<StoryResponse>(storyResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoryResponse> getStory(@PathVariable("id") long id) {
        StoryResponse storyResponse = storyService.get(id);
        return new ResponseEntity<StoryResponse>(storyResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StoryResponse> delete(@PathVariable("id") long id) throws Exception {
        StoryResponse storyResponse = storyService.delete(id);
        return new ResponseEntity<StoryResponse>(storyResponse, HttpStatus.OK);
    }

}
