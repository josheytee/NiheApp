package com.josheytee.niheapp.story;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/reactions")
public class ReactionController {
    private final ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }
//    @PostMapping
//    public ResponseEntity<BaseResponse<Reaction>> create(@RequestBody ReactionRequest reactionRequest){
//        Reaction reaction = this.reactionService.create(reactionRequest.toReaction());
//
//        BaseResponse<Reaction> reactionBaseResponse = new BaseResponse<>(201, "Reaction created Successfully!",
//                reaction);
//
//        return new ResponseEntity<>(reactionBaseResponse, HttpStatus.CREATED);
//    }


}