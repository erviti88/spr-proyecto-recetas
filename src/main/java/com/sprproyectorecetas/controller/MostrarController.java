package com.sprproyectorecetas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sprproyectorecetas.repository.RecetaRepository;

@Controller
public class MostrarController {
    
    @Autowired
    private RecetaRepository recetaRepository;

    // Maneja las solicitudes GET para la ruta "/mostrar"
    @GetMapping("/mostrar")
    public String mostrarRecetas(Model model) {
    	
        // Obtiene todas las recetas del repositorio y las agrega al modelo
    	model.addAttribute("recetas", recetaRepository.findAll());
        
        // Devuelve la vista "mostrar" para mostrar la lista de recetas
        return "mostrar";
    }
}