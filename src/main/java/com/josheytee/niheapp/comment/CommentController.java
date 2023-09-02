package com.josheytee.niheapp.comment;

import com.josheytee.niheapp.story.Story;
import com.josheytee.niheapp.app.BaseResponse;
import com.josheytee.niheapp.story.StoryService;
import com.josheytee.niheapp.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/story")
public class CommentController {

    private final CommentService commentService;

    private final UserService userService;
    private final StoryService storyService;

    public CommentController(CommentService commentService, UserService userService, StoryService storyService) {
        this.commentService = commentService;
        this.userService = userService;
        this.storyService = storyService;
    }

    @PostMapping("/{story_id}/comments")
    public ResponseEntity<BaseResponse<Comment>> create(@PathVariable(name = "story_id") long story_id,
                                                      @RequestBody CommentRequest commentRequest ) {
        Story story = this.storyService.get(story_id);
//        User user = this.userService.get(commentRequest.getUserid());
        Comment commentBuilder = Comment.builder()
                .content(commentRequest.getContent())
                .story(story)
                .build();
        Comment comment = this.commentService.create(commentBuilder);
        BaseResponse<Comment> commentBaseResponse = new BaseResponse<>(201, "Comment Created Successfully!", comment);
        return new ResponseEntity<>(commentBaseResponse, HttpStatus.CREATED);
    }


//
//    @GetMapping("/{id}")
//    public ResponseEntity<BaseResponse<Story>> getStory(@PathVariable("id") long id) {
//        Story story = commentService.get(id);
//
//        BaseResponse<Story> storyBaseResponse = new BaseResponse<>(200, "Story Fetched Successfully!", story);
//
//        return new ResponseEntity<>(storyBaseResponse, HttpStatus.OK);
//    }
//
//    //
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<BaseResponse<Story>> delete(@PathVariable("id") long id) throws Exception {
//        commentService.delete(id);
//        BaseResponse<Story> storyBaseResponse = new BaseResponse<>(200, "Story deleted Successfully!", null);
//
//        return new ResponseEntity<>(storyBaseResponse, HttpStatus.OK);
//    }

}