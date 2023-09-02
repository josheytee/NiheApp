package com.josheytee.niheapp.comment;

import com.josheytee.niheapp.app.AppCRUDServiceImpl;
import com.josheytee.niheapp.comment.Comment;
import com.josheytee.niheapp.comment.CommentRepository;
import com.josheytee.niheapp.comment.CommentService;
import org.springframework.stereotype.Component;

@Component
public class CommentServiceImpl extends AppCRUDServiceImpl<Comment> implements CommentService {
    private final CommentRepository commentRepository;
    public CommentServiceImpl(CommentRepository commentRepository) {
        super(commentRepository);
        this.commentRepository = commentRepository;
    }




//    @Override
//    public CommentResponse update(long Comment_id, CommentRequest CommentRequest) {
//        Comment Comment = this.CommentRepository.findById(Comment_id).orElseThrow();
//        Comment.setContent(CommentRequest.getContent());
//        Comment.setTitle(CommentRequest.getTitle());
//        this.CommentRepository.save(Comment);
//        CommentResponse CommentResponse = new CommentResponse();
//        CommentResponse.setData(Comment);
//        CommentResponse.setCode(200);
//        CommentResponse.setMessage("Comment " + Comment_id + " Updated");
//        return CommentResponse;
//    }
//
//    @Override
//    public List<CommentResponse> all(long Userid) {
//        return null;
//    }
//
//    @Override
//    public CommentResponse get(long Comment_id) {
//        Comment Comment = this.CommentRepository.findById(Comment_id).orElseThrow();
//        CommentResponse CommentResponse = new CommentResponse();
//        CommentResponse.setData(Comment);
//        CommentResponse.setCode(200);
//        CommentResponse.setMessage("Query Successful");
//        return CommentResponse;
//    }
//
//    @Override
//    public CommentResponse delete(long id) throws Exception {
//        try {
//            this.CommentRepository.deleteById(id);
//
//        } catch (Exception exception) {
//            throw new Exception("Error occurred while saving");
//        }
//        return null;
//    }
}