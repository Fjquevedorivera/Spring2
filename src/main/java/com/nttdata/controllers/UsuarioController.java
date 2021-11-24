package com.nttdata.controllers;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired // permite inyección de dependencias
	UsuarioService usuarioService;
	
	// Desplegar vista usuario
	@RequestMapping("")
	public String usuario(@ModelAttribute("usuario") Usuario usuario,
			Model model) {
		//Usuario usuario1= new Usuario();
		//List<Usuario> listaUsuarios = usuarioService.obtenerListaUsuarios();
		//model.addAttribute("usuario", new Usuario());
		
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		return "usuario/usuario.jsp";
	}
	
	// Capturar info formulario
	@RequestMapping("/login")
	/* public String login(@RequestParam("name") String name,
			@RequestParam("last_name") String last_name,
			@RequestParam("limit") String limit,
			@RequestParam("cp") String cp
			) { */
	public String login(@Valid @ModelAttribute("usuario") Usuario usuario) {
		//System.out.println(name+" "+last_name+" "+limit+" "+cp);
		//System.out.println(usuario.getName()+" "+usuario.getLast_name()+" "+usuario.getLimite()+" "+usuario.getCp());
		usuarioService.insertarUsuario(usuario);
		return "redirect:/usuario";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarObj(@RequestParam("id") Long id) {
		
		System.out.println("Id: "+ id);
		Usuario usuario = usuarioService.buscarUsuarioId(id);
		
		if(usuario != null) {
			usuarioService.eliminarUsuarioObj(usuario);
		}

		return "redirect:/usuario";
	}

	
	
}
