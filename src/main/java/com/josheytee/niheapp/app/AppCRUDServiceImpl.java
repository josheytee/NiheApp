package com.josheytee.niheapp.app;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class AppCRUDServiceImpl<T> implements AppCRUDService<T> {

    private final AppRepository<T, Long> appRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

//    private final ModelMapper modelMapper;

    public AppCRUDServiceImpl(AppRepository<T, Long> appRepository) {
        this.appRepository = appRepository;
//        modelMapper = new ModelMapper();
    }

    public AppCRUDServiceImpl(AppRepository<T, Long> appRepository, ApplicationEventPublisher eventPublisher) {
        this.appRepository = appRepository;
        this.eventPublisher = eventPublisher;
    }

    public ApplicationEventPublisher getEventPublisher() {
        return eventPublisher;
    }

    @Override
    public T create(T t) {
        return this.appRepository.save(t);
    }

    @Override
    public List<T> all() {
        return this.appRepository.findAll();
    }

    @Override
    public T update(long id, T tnew) {
        T byId = this.appRepository.findById(id).orElseThrow();
//        this.modelMapper.map(byId, tnew);
        BeanUtils.copyProperties(tnew, byId);

        return this.appRepository.save(byId);
    }

    @Override
    public T get(long id) {
        return (T) this.appRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(long id) throws Exception {
        this.appRepository.deleteById(id);
    }
}