package com.sprproyectorecetas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprproyectorecetas.model.Dificultad;

public interface DificultadRepository extends JpaRepository<Dificultad, Integer> {

    Object findByDificultad(String string);

}