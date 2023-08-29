package com.josheytee.niheapp.controllers;

import com.josheytee.niheapp.entities.Story;
import com.josheytee.niheapp.requests.StoryRequest;
import com.josheytee.niheapp.response.BaseResponse;
import com.josheytee.niheapp.services.StoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/story")
public class StoryController {

    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<Story>> create(@RequestBody StoryRequest storyRequest) {
        Story storyBuilder = Story.builder()
                .title(storyRequest.getTitle())
                .content(storyRequest.getContent())
                .build();
        Story story = this.storyService.create(storyBuilder);
        BaseResponse<Story> storyBaseResponse = new BaseResponse<>(201, "Story created Successfully!", story);
        return new ResponseEntity<>(storyBaseResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{story_id}")
    public ResponseEntity<BaseResponse<Story>> updateStory(ModelMapper modelMapper, @PathVariable long story_id,
                                                           @RequestBody StoryRequest storyRequest) {
        Story map = modelMapper.map(storyRequest, Story.class);
//        map.setId(story_id);
        BaseResponse.BaseResponseBuilder<Story> storyBaseResponse = BaseResponse.builder();
        try {
            Story story = this.storyService.update(story_id, map);

            storyBaseResponse.code(200)
                    .message("Story created Successfully!")
                    .data(story);
//            return new ResponseEntity<>(storyBaseResponse, HttpStatus.OK);
        } catch (Exception exception) {
            storyBaseResponse.code(400)
                    .message(exception.getMessage())
                    .data(null);
        }
            return new ResponseEntity<>(storyBaseResponse.build(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Story>> getStory(@PathVariable("id") long id) {
        Story story = storyService.get(id);

        BaseResponse<Story> storyBaseResponse = new BaseResponse<>(200, "Story Fetched Successfully!", story);

        return new ResponseEntity<>(storyBaseResponse, HttpStatus.OK);
    }

    //
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse<Story>> delete(@PathVariable("id") long id) throws Exception {
        storyService.delete(id);
        BaseResponse<Story> storyBaseResponse = new BaseResponse<>(200, "Story deleted Successfully!", null);

        return new ResponseEntity<>(storyBaseResponse, HttpStatus.OK);
    }

}