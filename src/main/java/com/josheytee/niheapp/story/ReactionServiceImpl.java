package com.josheytee.niheapp.story;

import com.josheytee.niheapp.app.AppCRUDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ReactionServiceImpl extends AppCRUDServiceImpl<Reaction> implements ReactionService{
    public ReactionServiceImpl(ReactionRepository reactionRepository) {
        super(reactionRepository);
    }
}