package com.sprproyectorecetas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sprproyectorecetas.model.Receta;
import com.sprproyectorecetas.repository.DificultadRepository;
import com.sprproyectorecetas.repository.RecetaRepository;

@Controller
public class InsertarController {
    
    @Autowired
    private DificultadRepository dificultadRepository;

    @Autowired
    private RecetaRepository recetaRepository;

    // Maneja las solicitudes GET para la ruta "/insertar"
    @GetMapping("/insertar")
    public String mostrarFormulario(Model model) {
    	
        // Obtiene todas las recetas del repositorio
    	List<Receta> recetas = recetaRepository.findAll();
    	
        // Agrega la lista de dificultades y una nueva instancia de Receta al modelo
    	model.addAttribute("dificultades", dificultadRepository.findAll());
        model.addAttribute("receta", new Receta());
        
        // Agrega la lista de recetas al modelo para mostrar en la vista
        model.addAttribute("recetas", recetas);
        
        // Devuelve la vista "insertar" para mostrar el formulario y la lista de recetas
        return "insertar";
    }

    // Maneja las solicitudes POST para la ruta "/insertar"
    @PostMapping("/insertar")
    public String insertarReceta(@ModelAttribute Receta receta) {
        
        // Guarda la nueva receta en el repositorio de recetas
    	recetaRepository.save(receta);
    	
        // Redirige a la ruta "/insertar" después de insertar la nueva receta
        return "redirect:/insertar";
    }
}