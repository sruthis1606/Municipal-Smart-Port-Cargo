package com.example.municipal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.municipal.model.Container;
import com.example.municipal.repository.ContainerRepository;

@Service
public class ContainerService {

    @Autowired
    private ContainerRepository repository;

    public List<Container> getAllContainers() {
        return repository.findAll();
    }

    public long getContainerCount() {
        return repository.count();
    }

    public Container addContainer(Container container) {
        return repository.save(container);
    }

    public void deleteContainer(Long id) {
        repository.deleteById(id);
    }
}