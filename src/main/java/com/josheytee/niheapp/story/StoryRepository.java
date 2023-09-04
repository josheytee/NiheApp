package com.josheytee.niheapp.story;

import com.josheytee.niheapp.app.AppRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends AppRepository<Story, Long> {
    @Query("select s from Story s where s.user.id in ?1")
    public List<Story> getAllFromFriendsId(List<Long> ids);
}