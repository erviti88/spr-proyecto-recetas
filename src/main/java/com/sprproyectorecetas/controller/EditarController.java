package com.sprproyectorecetas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sprproyectorecetas.model.Receta;
import com.sprproyectorecetas.repository.DificultadRepository;
import com.sprproyectorecetas.repository.RecetaRepository;

@Controller
public class EditarController {
    
    @Autowired
    private RecetaRepository recetaRepository;
	
    @Autowired
    private DificultadRepository dificultadRepository;
    
    // Maneja las solicitudes GET para la ruta "/editar/{id}"
    @RequestMapping("/editar/{id}")
    public String mostrarFormulario(@PathVariable int id, Model model) {
    	
        // Busca la receta por ID en el repositorio de recetas
    	Receta receta = recetaRepository.findById(id).orElse(null);
    	
        // Agrega la receta y la lista de dificultades al modelo
        model.addAttribute("receta", receta);
        model.addAttribute("dificultades", dificultadRepository.findAll());
        
        // Devuelve la vista "editar" para mostrar el formulario de edición
        return "editar";
    }
    
    // Maneja las solicitudes POST para la ruta "/editar"
    @PostMapping("/editar")
    public String editarReceta(@ModelAttribute Receta receta) {
    	
        // Guarda la receta actualizada en el repositorio de recetas
    	recetaRepository.save(receta);
    	
        // Redirige a la ruta "/mostrar" después de editar la receta
        return "redirect:/mostrar";
    }
}
