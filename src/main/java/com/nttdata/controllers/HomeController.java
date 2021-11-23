package com.nttdata.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
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

}
