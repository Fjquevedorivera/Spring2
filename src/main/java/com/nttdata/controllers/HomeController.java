package com.nttdata.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
public class HomeController {
	
	@Autowired // permite inyección de dependencias
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String index() {
		return "";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "usuario/login.jsp";
	}
	
	@RequestMapping("/registro")
	public String registro(@ModelAttribute("usuario") Usuario usuario) {
		return "usuario/registro.jsp";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		String nombre = (String) session.getAttribute("nombre_usuario");
		Long usuario_id = (Long) session.getAttribute("usuario_id");
		
		model.addAttribute("nombre_usuario", nombre);
		model.addAttribute("usuario_id", usuario_id);
		return "usuario/home.jsp";
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
