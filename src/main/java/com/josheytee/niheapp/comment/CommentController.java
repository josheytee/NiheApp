package com.josheytee.niheapp.comment;

import com.josheytee.niheapp.app.BaseResponse;
import com.josheytee.niheapp.story.Story;
import com.josheytee.niheapp.story.StoryService;
import com.josheytee.niheapp.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/stories")
public class CommentController {

    private final CommentService commentService;
    private final StoryService storyService;

    public CommentController(CommentService commentService, StoryService storyService) {
        this.commentService = commentService;
        this.storyService = storyService;
    }

    @PostMapping("/{story_id}/comments")
    public ResponseEntity<BaseResponse<Comment>> create(@PathVariable(name = "story_id") long story_id,
                                                        @RequestBody CommentRequest commentRequest,
                                                        @AuthenticationPrincipal User user) {
        Story story = this.storyService.get(story_id);
        Comment comment = this.commentService.create(commentRequest.toComment(user, story));
        BaseResponse<Comment> commentBaseResponse = new BaseResponse<>(201, "Comment Created Successfully!", comment);
        return new ResponseEntity<>(commentBaseResponse, HttpStatus.CREATED);
    }


    @GetMapping("/{story_id}/comments")
    public ResponseEntity<BaseResponse<List<Comment>>> comments(@PathVariable("story_id") long id) {
        List<Comment> comments = this.storyService.get(id).getComments();

        BaseResponse<List<Comment>> listBaseResponse =
                new BaseResponse<>(200, "Story Comments Fetched Successfully!", comments);

        return new ResponseEntity<>(listBaseResponse, HttpStatus.OK);
    }

    @GetMapping("/{story_id}/comments/{id}")
    public ResponseEntity<BaseResponse<Comment>> getComment(@PathVariable("story_id") long story_id, @PathVariable("id") long id) {
        List<Comment> comments = storyService.get(story_id).getComments();
        Comment comment = comments.stream().filter(c -> c.getId().equals(id))
                .findAny()
                .orElseThrow();

        BaseResponse<Comment> storyBaseResponse =
                new BaseResponse<>(200, "Comment Fetched Successfully!", comment);

        return new ResponseEntity<>(storyBaseResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{story_id}/comments/{id}}")
    public ResponseEntity<BaseResponse<Story>> delete(@PathVariable("id") long id) throws Exception {
        commentService.delete(id);
        //@todo: to be implemented later
        BaseResponse<Story> storyBaseResponse = new BaseResponse<>(200, "Comment deleted Successfully!", null);

        return new ResponseEntity<>(storyBaseResponse, HttpStatus.OK);
    }

}