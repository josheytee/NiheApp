package com.josheytee.niheapp.dto.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoryRequest {
    long id;
    String title;
    String content;
}
