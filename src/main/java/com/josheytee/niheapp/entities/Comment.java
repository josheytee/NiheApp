package com.josheytee.niheapp.entities;

import jakarta.persistence.Entity;
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
    private String text;
//    private ArrayList<String> attachments;

//    protected ArrayList<Reaction> reactions;

//    private User user;

//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "story_id", nullable = false)
//    private Story story;



}