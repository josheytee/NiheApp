package com.josheytee.niheapp.services.impl;

import com.josheytee.niheapp.entities.Story;
import com.josheytee.niheapp.repositories.StoryRepository;
import com.josheytee.niheapp.response.dto.StoryDTO;
import com.josheytee.niheapp.services.StoryService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoryServiceImpl extends BaseCRUDServiceImpl<Story> implements StoryService{
    private final StoryRepository storyRepository;

    public StoryServiceImpl(StoryRepository storyRepository) {
        super(storyRepository);
        this.storyRepository = storyRepository;
    }

    @Override
    public List<StoryDTO> getUserStories(long userid) {
        return this.storyRepository.findAll().stream().map(s -> {
            return StoryDTO.builder()
                    .title(s.getTitle())
                    .content(s.getContent())
                    .build();

        }).collect(Collectors.toList());
    }



//    @Override
//    public StoryResponse create(Story story) {
//        Story savedStory = this.storyRepository.save(story);
//        StoryResponse storyResponse = new StoryResponse();
//        storyResponse.setData(savedStory);
//        storyResponse.setCode(201);
//        storyResponse.setMessage("Story Created");
//        return storyResponse;
//    }
//
//    @Override
//    public StoryResponse update(long story_id, StoryRequest storyRequest) {
//        Story story = this.storyRepository.findById(story_id).orElseThrow();
//        story.setContent(storyRequest.getContent());
//        story.setTitle(storyRequest.getTitle());
//        this.storyRepository.save(story);
//        StoryResponse storyResponse = new StoryResponse();
//        storyResponse.setData(story);
//        storyResponse.setCode(200);
//        storyResponse.setMessage("Story " + story_id + " Updated");
//        return storyResponse;
//    }
//
//    @Override
//    public List<StoryResponse> all(long Userid) {
//        return null;
//    }
//
//    @Override
//    public StoryResponse get(long story_id) {
//        Story story = this.storyRepository.findById(story_id).orElseThrow();
//        StoryResponse storyResponse = new StoryResponse();
//        storyResponse.setData(story);
//        storyResponse.setCode(200);
//        storyResponse.setMessage("Query Successful");
//        return storyResponse;
//    }
//
//    @Override
//    public StoryResponse delete(long id) throws Exception {
//        try {
//            this.storyRepository.deleteById(id);
//
//        } catch (Exception exception) {
//            throw new Exception("Error occurred while saving");
//        }
//        return null;
//    }
}