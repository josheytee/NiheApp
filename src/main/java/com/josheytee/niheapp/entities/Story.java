package com.josheytee.niheapp.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_story_id", referencedColumnName = "id")
    ArrayList<Comment> comments;
}