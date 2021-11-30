package com.nttdata.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Usuario;
import com.nttdata.services.ProyectoService;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired // permite inyección de dependencias
	UsuarioService usuarioService;
	
	@Autowired // permite inyección de dependencias
	ProyectoService proyectoService;
	
	// Desplegar vista usuario
	@RequestMapping("")
	public String usuario(@ModelAttribute("usuario") Usuario usuario,
			Model model) {
		//Usuario usuario1= new Usuario();
		//List<Usuario> listaUsuarios = usuarioService.obtenerListaUsuarios();
		//model.addAttribute("usuario", new Usuario());
		usuarioService.getUsuariosNombres();
		List<Object[]> oUsuario = usuarioService.getUsuariosNombresApellidos();
		oUsuario.get(0);//oUsuario.get(0)[0];
		usuarioService.getUsuariosNombresApellidosSQL();
		List<Usuario> lUsuario = usuarioService.getUsuarioById(20L);
		
		model.addAttribute("listaProyectos", proyectoService.obtenerListaProyectos());
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		return "usuario/usuario.jsp";
	}
	
	@RequestMapping("registrarjsp")
	public String usuario(@ModelAttribute("usuario") Usuario usuario) {
		return "usuario/registro.jsp";
	}
	
	@RequestMapping("/registrar")
	public String registro(@Valid @ModelAttribute("usuario") Usuario usuario) {
		Usuario usuario_existe = usuarioService.findByEmail(usuario.getEmail());
		//encript password
		if(usuario_existe == null) {
			usuarioService.registroUsuario(usuario);
		}
//		usuarioService.registroUsuario(usuario);
		return "usuario/login.jsp";
	}
	
	@RequestMapping("/ingresar")
	public String login(@ModelAttribute("usuario") Usuario usuario) {
		return "usuario/login.jsp";
	}
	
	@RequestMapping("/login")
	public String ingresar(@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session) {
		boolean is_logged = usuarioService.loginUsuario(email, password);
		if(is_logged) {
			Usuario usuario = usuarioService.findByEmail(email);
			session.setAttribute("usuario_id", usuario.getId());
			session.setAttribute("nombre_usuario", usuario.getName());
			return "redirect:/home";
		} else {
			return "redirect:/usuario/ingresar";
		}
		
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
	
	@RequestMapping("/editar")
	public String editar(@RequestParam("id") Long id, Model model) {
		
		Usuario usuario = usuarioService.buscarUsuarioId(id);
		if(usuario != null) {
			model.addAttribute("usuario", usuario);
			model.addAttribute("listaProyectos", proyectoService.obtenerListaProyectos());
			return "usuario/editar.jsp";
		}

		return "redirect:/usuario";
		
	}
	
	@RequestMapping(value="/actualizar", method = RequestMethod.PUT)
	public String actualizar(@Valid @ModelAttribute("usuario") Usuario usuario, Model model) {
		System.out.println("id " + usuario.getId());
		usuarioService.actualizarUsuario(usuario);
		return "redirect:/usuario";
	}
	
	public String validaUsuario(Usuario usuario) {
		String error="";
		
		if(usuario.getName()==null || usuario.getName().isEmpty() || usuario.getLast_name()==null || usuario.getLast_name()==null
				|| usuario.getLast_name().isEmpty() || usuario.getLimite()==null || usuario.getLimite().isEmpty() || usuario.getCp()==null
				|| usuario.getCp().isEmpty()) {
			error="Los campos no pueden estar vacíos!";
		return "error.jsp";
		}

		if(containsDigit(usuario.getName())) {
			error="El nombre no puede contener números! ";
		}else if(usuario.getName().length()<1 || usuario.getName().length()>10) {
			error+="El nombre debe tener de 1 a 10 caracteres! ";
		}

		if(containsDigit(usuario.getLast_name())) {
			error+="El apellido no puede contener números! ";
		}else if(usuario.getLast_name().length()<1 || usuario.getLast_name().length()>10) {
			error+="El Apellido debe tener de 1 a 10 caracteres! ";
		}

		if(!isNumeric(usuario.getLimite())) {
			error+="El limite debe ser un número! ";
		}else if(Integer.parseInt(usuario.getLimite())<0 || usuario.getLimite().length()>=6) {
			error+="El límite debe ser un número positivo y menor a 6 dígitos! ";
		}

		if(!isNumeric(usuario.getCp())) {
			error+="El codigo postal debe ser un número! ";
		}else if(usuario.getCp().length()!=8) {
			error+="El codigo postal debe ser de 8 dígitos!";
		}
		
		return error;
	}
	
	//Verifica si el string es un número
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			System.out.println("error: "+nfe.getMessage());
			return false;
		}
	}

	//Verifica si el string contiene números
	public static boolean containsDigit(String s) {
		boolean containsDigit = false;
		for (char c : s.toCharArray()) {
			if (containsDigit = Character.isDigit(c)) {
				containsDigit=true;
				break;
			}
		}
		
		return containsDigit;
	}
	
}
