package com.nttdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@RequestMapping("")
	public String cliente(Model model) {
		model.addAttribute("name", "Francisco");
		model.addAttribute("last", "Quevedo");
		return "cliente/cliente.jsp";
	}
	
	@RequestMapping("/pagos")
	public String pagos() {
		return "Client Payment";
	}
	
	// recibir parametros por URL http://localhost:8080/m/{rut}/{dv}
	@RequestMapping("/m/{rut}/{dv}")
	// @PathVariable("variable" type name)
	public String rutCliente(	
			@PathVariable("rut") Integer rut, 
			@PathVariable("dv") String dv) {
		return "El rut es: "+rut+" , de digito "+dv;
	}
	
}
