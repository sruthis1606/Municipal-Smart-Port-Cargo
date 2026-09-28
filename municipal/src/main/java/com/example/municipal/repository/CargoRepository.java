package com.example.municipal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.municipal.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}