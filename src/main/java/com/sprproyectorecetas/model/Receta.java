package com.sprproyectorecetas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "recetas")
public class Receta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "nombre")
    private String nombre;
    
    @Column (name = "calorias")
    private int calorias;

    @ManyToOne
    @JoinColumn(name = "FK_dificultad")
    private Dificultad dificultad;

    public Receta(int id, String nombre, int calorias, Dificultad dificultad) {
        this.id = id;
        this.nombre = nombre;
        this.calorias = calorias;
        this.dificultad = dificultad;
    }

    public Receta() {
        this.id = 0;
        this.nombre = "";
        this.calorias = 0;
        this.dificultad = new Dificultad();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    @Override
    public String toString() {
        return "Receta [id=" + id + ", nombre=" + nombre + ", calorias=" + calorias + ", dificultad=" + dificultad + "]";
    }
}