package com.josheytee.niheapp.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Story extends BaseEntity {
    String title;
    String content;
//    ArrayList<String> attachments;
//    ArrayList<Reaction> reactions;
//    ArrayList<Comment> comments;
}
