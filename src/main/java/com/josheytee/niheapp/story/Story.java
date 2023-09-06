package com.josheytee.niheapp.story;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.josheytee.niheapp.comment.Comment;
import com.josheytee.niheapp.reaction.Reaction;
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
@NoArgsConstructor
@Table(name = "stories")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    //    ArrayList<String> attachments;

    //    @JoinTable(
//            name = "story_reactions",
//            joinColumns = @JoinColumn(name = "stories_id"),
//            inverseJoinColumns = @JoinColumn(name = "reactions_id"))
    @OneToMany(mappedBy = "story")
    private List<Reaction> reactions;

    @OneToOne
    private Story parent;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;

    @OneToMany(mappedBy = "story")
    private List<Comment> comments;

}