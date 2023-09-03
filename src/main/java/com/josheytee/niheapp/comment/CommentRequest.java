package com.josheytee.niheapp.comment;

import com.josheytee.niheapp.story.Story;
import com.josheytee.niheapp.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {
    String content;

    public Comment toComment(User user, Story story){
        return Comment.builder()
                .content(this.getContent())
                .user(user)
                .story(story)
                .build();
    }
}