package com.nttdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@RequestMapping("")
	public String index() {
		return "proveedor/proveedor.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insert(@RequestParam("name") String name,
			@RequestParam("last-name") String last_name,
			@RequestParam("email") String email,
			@RequestParam("age") String age
	) {
		
		if(age.isEmpty()) {
			System.out.println("Error 404");
		} else {
			System.out.println("Nombre: "+ name);
			System.out.println("Email: "+ email);
		}

		//return "proveedor/proveedor.jsp";
		return "redirect:/proveedor";
	}

}
