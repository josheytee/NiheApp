package com.josheytee.niheapp.app;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "entity-aware-generator", strategy = GenerationType.SEQUENCE)
//    @GenericGenerator(name = "entity-aware-generator", strategy = {EntityAwareGenerator.NAME})
    private Long id;

//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
////    @Column(name = "id", nullable = false, unique =true, updatable = false)
//    public Long getId() {
//        return this.id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
}