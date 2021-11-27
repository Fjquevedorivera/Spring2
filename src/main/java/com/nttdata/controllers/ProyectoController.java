package com.nttdata.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Proyecto;
import com.nttdata.models.Usuario;
import com.nttdata.services.ProyectoService;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/proyecto")
public class ProyectoController {

	@Autowired
	ProyectoService proyectoService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String proyecto(Model model) {
		model.addAttribute("proyecto", new Proyecto());
		model.addAttribute("listaProyectos", proyectoService.obtenerListaProyectos());
	  
		// Para utilizar objeto 
		List<Object[]> proyectoUsuarios = proyectoService.getProyectosYUsuarios();
		List<Proyecto> proyectoJUsuarios = proyectoService.getProyectosJUsuarios();
	  
		// Para usar objeto con getter y setter 
		for(Object[] fila: proyectoUsuarios) { 
			System.out.println(fila); 
			Proyecto proyecto = (Proyecto) fila[0];
			System.out.println("proyecto "+proyecto); 
			Usuario usuario = (Usuario) fila[1];
			System.out.println("usuario "+usuario); 
		}
		
		model.addAttribute("proyectoUsuarios", proyectoUsuarios);
		
		return "proyecto/proyecto.jsp";
	}
	
	@RequestMapping("/crear")
	public String login(@Valid @ModelAttribute("proyecto") Proyecto proyecto) {
		proyectoService.insertarProyecto(proyecto);
		return "redirect:/proyecto";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarObj(@RequestParam("id") Long id) {
		
		System.out.println("Id: "+ id);
		Proyecto proyecto = proyectoService.buscarProyectoId(id);
		
		if(proyecto != null) {
			proyectoService.eliminarProyectoObj(proyecto);
		}

		return "redirect:/proyecto";
	}
	
	@RequestMapping("/editar")
	public String editar(@RequestParam("id") Long id, Model model) {
		Proyecto proyecto = proyectoService.buscarProyectoId(id);
		if(proyecto != null) {
			model.addAttribute("proyecto", proyecto);
			return "/proyecto/proyecto.jsp";
		}
		return "redirect:/proyeto";
	}
	
}
