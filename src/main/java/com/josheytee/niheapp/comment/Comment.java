package com.josheytee.niheapp.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.josheytee.niheapp.story.Story;
import com.josheytee.niheapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
//    private ArrayList<String> attachments;

//    protected ArrayList<Reaction> reactions;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    //    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Story story;


}