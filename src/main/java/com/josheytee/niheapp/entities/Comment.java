package com.josheytee.niheapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseEntity{
    private String content;
//    private ArrayList<String> attachments;

//    protected ArrayList<Reaction> reactions;

//    private User user;

//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="story_id")
    private Story story;



}