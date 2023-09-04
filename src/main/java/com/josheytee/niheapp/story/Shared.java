package com.josheytee.niheapp.story;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.josheytee.niheapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reactions")
public class Shared {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private Story story;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;

}