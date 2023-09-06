package com.josheytee.niheapp.story;

import com.josheytee.niheapp.app.BaseResponse;
import com.josheytee.niheapp.reaction.Reaction;
import com.josheytee.niheapp.reaction.ReactionRequest;
import com.josheytee.niheapp.reaction.ReactionService;
import com.josheytee.niheapp.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/stories")
public class StoryController {

    private final StoryService storyService;
    private final ReactionService reactionService;

    public StoryController(StoryService storyService, ReactionService reactionService) {
        this.storyService = storyService;
        this.reactionService = reactionService;
    }

    @PostMapping()
    public ResponseEntity<BaseResponse<Story>> create(@AuthenticationPrincipal User user,
                                                      @RequestBody StoryRequest storyRequest) {
        Story story = this.storyService.create(storyRequest.toStory(user));
        BaseResponse<Story> storyBaseResponse = new BaseResponse<>(201, "Story created Successfully!", story);
        return new ResponseEntity<>(storyBaseResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<Story>>> stories(@AuthenticationPrincipal User user) {
        List<Story> stories = user.getStories();

        BaseResponse<List<Story>> baseResponse = new BaseResponse<>(200, "User stories fetched Successfully!",
                stories);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Story>> delete(@PathVariable("id") long id) throws Exception {
        storyService.delete(id);
        BaseResponse<Story> storyBaseResponse = new BaseResponse<>(200, "Story deleted Successfully!", null);

        return new ResponseEntity<>(storyBaseResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}/react")
    public ResponseEntity<BaseResponse<Reaction>> addReaction(@PathVariable("id") long id,
                                                              @RequestBody ReactionRequest reactionRequest,
                                                              @AuthenticationPrincipal User user) {
        Story story = storyService.get(id);
        Reaction reaction = reactionService.create(reactionRequest.toReaction(user, story));
        BaseResponse<Reaction> reactionBaseResponse = new BaseResponse<>(201, "Reaction added Successfully!", reaction);
        return new ResponseEntity<>(reactionBaseResponse, HttpStatus.CREATED);
    }
    @PostMapping("/{id}/share")
    public ResponseEntity<BaseResponse<Story>> share(@PathVariable("id") long id,
                                                   @RequestBody StoryRequest storyRequest,
                                                    @AuthenticationPrincipal User user) {
        Story parent = storyService.get(id);
        Story sharedStory = this.storyService.create(storyRequest.toStory(user, parent));
        BaseResponse<Story> sharedStoryBaseResponse = new BaseResponse<>(201, "Share Successful!",
                sharedStory);
        return new ResponseEntity<>(sharedStoryBaseResponse, HttpStatus.CREATED);
    }

}