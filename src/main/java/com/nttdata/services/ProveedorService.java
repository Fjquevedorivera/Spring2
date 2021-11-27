package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Proveedor;
import com.nttdata.repositories.ProveedorRepository;

@Service
public class ProveedorService {
	@Autowired
	ProveedorRepository proveedorRepository;

	public List<Proveedor> obtenerListaProveedores() {
		return proveedorRepository.findAll();
	}
	
	
}
