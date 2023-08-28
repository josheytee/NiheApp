package com.josheytee.niheapp.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Story extends BaseEntity {
    private String title;
    private String content;
//    ArrayList<String> attachments;
//    ArrayList<Reaction> reactions;
//    ArrayList<Comment> comments;
}