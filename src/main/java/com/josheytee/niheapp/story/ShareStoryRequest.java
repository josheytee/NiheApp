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
public class ShareStoryRequest {
    private User user;
    private Story story;

    SharedStory toSharedStory(User user, Story story) {
        return SharedStory.builder()
                .user(user)
                .story(story)
                .build();
    }
}