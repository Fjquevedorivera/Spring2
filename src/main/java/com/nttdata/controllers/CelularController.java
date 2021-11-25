package com.nttdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Celular;
import com.nttdata.models.Usuario;
import com.nttdata.services.CelularService;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/celular")
public class CelularController {
	
	@Autowired // permite inyección de dependencias
	UsuarioService usuarioService;
	
	@Autowired // permite inyección de dependencias
	CelularService celularService;
	
	@RequestMapping("")
	public String celular(Model model,
			@ModelAttribute("celular") Celular celular) {
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		return "celular/celular.jsp";
	}
	
	@RequestMapping("/crear")
	public String crear(@ModelAttribute("celular") Celular celular) {
		celularService.insertarCelular(celular);
		return "redirect:/celular.jsp";
	}
	
	
}
