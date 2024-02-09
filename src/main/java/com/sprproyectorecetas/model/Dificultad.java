package com.sprproyectorecetas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dificultad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "dificultad")
    private String dificultad;

    public Dificultad(int id, String dificultad) {
        this.id = id;
        this.dificultad = dificultad;
    }

    public Dificultad() {
        this.id = 0;
        this.dificultad = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    @Override
    public String toString() {
        return "Dificultad [id=" + id + ", dificultad=" + dificultad + "]";
    }
}