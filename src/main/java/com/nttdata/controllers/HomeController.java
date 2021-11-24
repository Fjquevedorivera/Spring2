package com.nttdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@RestController
public class HomeController {
	
	@Autowired // permite inyección de dependencias
	UsuarioService usuarioService;
	
	@RequestMapping("/")
	//http://localhost:8080/index
	// Start Method
	public String index() {
		return "Hello World !!!";
	}
	
	@RequestMapping("/show")
	public String show() {
		return "Show World !!!";
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "Edit World !!!";
	}
	
	@RequestMapping("/edit/data")
	public String editData() {
		return "Edit World Data !!!";
	}
	
	@RequestMapping("/eliminar/usuario/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		
		System.out.println("Id: "+ id);
		Usuario usuario = usuarioService.buscarUsuarioId(id);
		if(usuario != null) {
			usuarioService.eliminarUsuario(id);
		}
		return "Usuario Eliminado";
	}

}
