package com.josheytee.niheapp.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AppRepository<T, L> extends JpaRepository<T, L> {
}