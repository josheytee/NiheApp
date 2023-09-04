package com.josheytee.niheapp.story;

import com.josheytee.niheapp.app.AppCRUDServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoryServiceImpl extends AppCRUDServiceImpl<Story> implements StoryService{
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
}