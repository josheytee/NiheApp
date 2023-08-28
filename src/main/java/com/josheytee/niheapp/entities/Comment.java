package com.josheytee.niheapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment extends BaseEntity{
    private String text;
//    private ArrayList<String> attachments;

//    protected ArrayList<Reaction> reactions;


//    @ManyToOne
//    @JoinColumn(name="user_id")
//    private User user;



}
