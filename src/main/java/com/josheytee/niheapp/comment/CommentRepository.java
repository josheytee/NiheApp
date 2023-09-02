package com.josheytee.niheapp.comment;

import com.josheytee.niheapp.app.AppRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends AppRepository<Comment, Long> {
//    List<Comment> findByStoryId(Long storyId);
//
//    @Transactional
//    void deleteByStoryId(long storyId);
}