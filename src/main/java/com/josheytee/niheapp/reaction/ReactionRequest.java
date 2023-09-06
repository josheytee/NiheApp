package com.josheytee.niheapp.reaction;

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
public class ReactionRequest {
    private Emotion emotion;
    private User user;
    private Story story;

    public Reaction toReaction(User user, Story story) {
        return Reaction.builder()
                .emotion(emotion)
                .user(user)
                .story(story)
                .build();
    }
}