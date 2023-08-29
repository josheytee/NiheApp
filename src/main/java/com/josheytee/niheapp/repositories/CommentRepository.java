package com.josheytee.niheapp.repositories;

import com.josheytee.niheapp.entities.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends BaseRepository<Comment, Long> {
//    List<Comment> findByStoryId(Long storyId);
//
//    @Transactional
//    void deleteByStoryId(long storyId);
}