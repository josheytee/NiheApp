package com.josheytee.niheapp.story;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReactionRequest {
    String code;
    String name;

    Reaction toReaction() {
        return Reaction.builder()
                .code(this.getCode())
                .name(this.getName())
                .build();
    }
}