package com.josheytee.niheapp.story;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.josheytee.niheapp.comment.Comment;
import com.josheytee.niheapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stories")
public class Story  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    //    ArrayList<String> attachments;
    @ManyToMany
    @JoinTable(
            name = "story_reactions",
            joinColumns = @JoinColumn(name = "stories_id"),
            inverseJoinColumns = @JoinColumn(name = "reactions_id"))
    Set<Reaction> reactions;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;

    @OneToMany(mappedBy = "story")
    List<Comment> comments;

}