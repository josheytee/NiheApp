package com.josheytee.niheapp.story;

import com.josheytee.niheapp.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoryRequest {
    String title;
    String content;
    Story parent;

    Story toStory(User user) {
        return Story.builder()
                .title(this.getTitle())
                .content(this.getContent())
                .user(user)
                .build();
    }
    Story toStory(User user, Story parent) {
        return Story.builder()
                .title(this.getTitle())
                .content(this.getContent())
                .parent(parent)
                .user(user)
                .build();
    }
}