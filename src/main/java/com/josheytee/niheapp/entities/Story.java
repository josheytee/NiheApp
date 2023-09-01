package com.josheytee.niheapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Story extends BaseEntity {
    private String title;
    private String content;
//    ArrayList<String> attachments;
//    ArrayList<Reaction> reactions;

    @OneToMany(mappedBy = "story")
    List<Comment> comments;
}