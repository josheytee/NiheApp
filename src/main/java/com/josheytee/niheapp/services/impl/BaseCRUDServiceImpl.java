package com.josheytee.niheapp.services.impl;

import com.josheytee.niheapp.repositories.BaseRepository;
import com.josheytee.niheapp.services.BaseCRUDService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class BaseCRUDServiceImpl<T> implements BaseCRUDService<T> {

    private final BaseRepository<T, Long> baseRepository;

//    private final ModelMapper modelMapper;

    public BaseCRUDServiceImpl(BaseRepository<T, Long> baseRepository) {
        this.baseRepository = baseRepository;
//        modelMapper = new ModelMapper();
    }

    @Override
    public T create(T t) {
        return this.baseRepository.save(t);
    }

    @Override
    public List<T> all() {
        return this.baseRepository.findAll();
    }

    @Override
    public T update(long id, T tnew) {
        T byId = this.baseRepository.findById(id).orElseThrow();
//        this.modelMapper.map(byId, tnew);
        BeanUtils.copyProperties(tnew, byId);

        return this.baseRepository.save(byId);
    }

    @Override
    public T get(long id) {
        return (T) this.baseRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(long id) throws Exception {
        this.baseRepository.deleteById(id);
    }
}