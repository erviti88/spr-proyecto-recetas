package com.sprproyectorecetas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprproyectorecetas.model.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Integer> {
    
}