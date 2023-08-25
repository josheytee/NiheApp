package com.josheytee.niheapp.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseEntity {
    private long id;

    public BaseEntity() {
    }

//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique =true, updatable = false)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
