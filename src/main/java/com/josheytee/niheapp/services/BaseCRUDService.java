package com.josheytee.niheapp.services;


import java.util.List;

public interface BaseCRUDService<T> {

    public T create(T t);

    public List<T> all();

    public T update(long id, T tnew);

    public T get(long id);
    public void delete(long id) throws Exception;
}