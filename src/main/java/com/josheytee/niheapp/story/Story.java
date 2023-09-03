package com.josheytee.niheapp.story;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.josheytee.niheapp.app.EntityAwareGeneratorParams;
import com.josheytee.niheapp.comment.Comment;
import com.josheytee.niheapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@EntityAwareGeneratorParams(sequence="story sequence")
@NoArgsConstructor
public class Story  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    //    ArrayList<String> attachments;
//    ArrayList<Reaction> reactions;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;

    @OneToMany(mappedBy = "story")
    List<Comment> comments;
}