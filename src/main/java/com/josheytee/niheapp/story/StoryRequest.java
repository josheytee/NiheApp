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

    Story toStory(User user) {
        return Story.builder()
                .title(this.getTitle())
                .content(this.getContent())
                .user(user)
                .build();
    }
}