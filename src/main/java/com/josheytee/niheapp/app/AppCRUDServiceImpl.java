package com.josheytee.niheapp.app;

import com.josheytee.niheapp.app.AppRepository;
import com.josheytee.niheapp.app.AppCRUDService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class AppCRUDServiceImpl<T> implements AppCRUDService<T> {

    private final AppRepository<T, Long> appRepository;

//    private final ModelMapper modelMapper;

    public AppCRUDServiceImpl(AppRepository<T, Long> appRepository) {
        this.appRepository = appRepository;
//        modelMapper = new ModelMapper();
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