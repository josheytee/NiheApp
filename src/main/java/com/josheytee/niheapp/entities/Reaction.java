package com.josheytee.niheapp.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reaction extends BaseEntity {

//    private User user;
//    private Story story;
    public Emotion emotion;
}

 enum Emotion{
    LIKE, CLAP, LOVE, CARE
}