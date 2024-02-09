package com.sprproyectorecetas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sprproyectorecetas.repository.RecetaRepository;

@Controller
public class BorrarController {
    
    @Autowired
    private RecetaRepository recetaRepository;

    // Maneja las solicitudes GET para la ruta "/borrar/{id}"
	@GetMapping("/borrar/{id}")
	public String borrarReceta(@PathVariable int id) {
		
        // Utiliza el RecetaRepository para eliminar la receta con el ID proporcionado
    	recetaRepository.deleteById(id);
		
		// Redirige a la ruta "/insertar" después de borrar la receta
		return "redirect:/insertar";
	}
}
