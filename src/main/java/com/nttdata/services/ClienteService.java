package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Cliente;
import com.nttdata.models.Proyecto;
import com.nttdata.repositories.ClienteRepository;
import com.nttdata.repositories.ProyectoRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> obtenerListaClientes() {
		//return clienteRepository.findAll();
		return clienteRepository.findAllClientes();
	}

	public void insertarCliente(@Valid Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public Cliente buscarClienteId(Long id) {
		return clienteRepository.findById(id).get();
	}

	public void eliminarProyecto(Long id) {
		clienteRepository.deleteById(id);
	}

	public void eliminarClienteObj(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
}
