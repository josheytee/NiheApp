package com.josheytee.niheapp.story;

import com.josheytee.niheapp.app.BaseResponse;
import com.josheytee.niheapp.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/stories")
public class StoryController {

    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping()
    public ResponseEntity<BaseResponse<Story>> create(@AuthenticationPrincipal User user,
                                                      @RequestBody StoryRequest storyRequest) {
        Story story = this.storyService.create(storyRequest.toStory(user));
        BaseResponse<Story> storyBaseResponse = new BaseResponse<>(201, "Story created Successfully!", story);
        return new ResponseEntity<>(storyBaseResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{story_id}")
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
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Story>> delete(@PathVariable("id") long id) throws Exception {
        storyService.delete(id);
        BaseResponse<Story> storyBaseResponse = new BaseResponse<>(200, "Story deleted Successfully!", null);

        return new ResponseEntity<>(storyBaseResponse, HttpStatus.OK);
    }

    //    @PostMapping("/{userid}")
//    public ResponseEntity<BaseResponse<List<StoryDTO>>> all(long userid) {
//        List<StoryDTO> userStories = storyService.getUserStories(userid);
//        BaseResponse<List<StoryDTO>> listBaseResponse = new BaseResponse<>();
//        listBaseResponse.setData(userStories);
//        listBaseResponse.setMessage("Successfully Fetched user stories");
//        listBaseResponse.setCode(201);
//        return new ResponseEntity<>(listBaseResponse, HttpStatus.CREATED);
//
//    }

}