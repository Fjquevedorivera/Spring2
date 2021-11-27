package com.nttdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Cliente;
import com.nttdata.services.ClienteService;
import com.nttdata.services.ProveedorService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ProveedorService proveedorService; 
	@Autowired
	ClienteService clienteService; 
	
	@RequestMapping("")
	public String cliente(Model model, @ModelAttribute("cliente") Cliente cliente) {
		model.addAttribute("listaClientes", clienteService.obtenerListaClientes());
		model.addAttribute("listaProveedores", proveedorService.obtenerListaProveedores());
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
	
	@RequestMapping("/crear")
	public String crearCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteService.insertarCliente(cliente);
		System.out.println(cliente);
		return "redirect:/cliente";
	}
	
	@RequestMapping("/editar")
	public String editar(@ModelAttribute("cliente") Cliente cliente, Model model) {
		model.addAttribute("listaProveedores", proveedorService.obtenerListaProveedores());
		return "redirect:/cliente/editar";
	}
	
}
