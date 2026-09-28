package com.example.municipal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.municipal.model.Container;
import com.example.municipal.service.ContainerService;

@RestController
@RequestMapping("/api/containers")
@CrossOrigin
public class ContainerController {

    @Autowired
    private ContainerService service;

    @GetMapping
    public List<Container> getContainers() {
        return service.getAllContainers();
    }

    @GetMapping("/count")
    public long getContainerCount() {
        return service.getContainerCount();
    }

    @PostMapping
    public Container addContainer(@RequestBody Container container) {
        return service.addContainer(container);
    }

    @DeleteMapping("/{id}")
    public void deleteContainer(@PathVariable Long id) {
        service.deleteContainer(id);
    }
}