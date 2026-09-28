package com.example.municipal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.municipal.model.Cargo;
import com.example.municipal.repository.CargoRepository;

@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;

    public List<Cargo> getAllCargo() {
        return repository.findAll();
    }

    public Cargo addCargo(Cargo cargo) {
        return repository.save(cargo);
    }

    public void deleteCargo(Long id) {
        repository.deleteById(id);
    }
}