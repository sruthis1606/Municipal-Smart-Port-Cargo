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

import com.example.municipal.model.Cargo;
import com.example.municipal.service.CargoService;

@RestController
@RequestMapping("/api/cargo")
@CrossOrigin
public class CargoController {

    @Autowired
    private CargoService service;

    @GetMapping
    public List<Cargo> getCargo() {
        return service.getAllCargo();
    }

    @PostMapping
    public Cargo addCargo(@RequestBody Cargo cargo) {
        return service.addCargo(cargo);
    }

    @DeleteMapping("/{id}")
    public void deleteCargo(@PathVariable Long id) {
        service.deleteCargo(id);
    }
}