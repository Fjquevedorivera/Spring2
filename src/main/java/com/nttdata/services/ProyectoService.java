package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Proyecto;
import com.nttdata.models.Usuario;
import com.nttdata.repositories.ProyectoRepository;
import com.nttdata.repositories.UsuarioRepository;

@Service
public class ProyectoService {
	
	@Autowired
	ProyectoRepository proyectoRepository;
	
	public List<Proyecto> obtenerListaProyectos() {
		return proyectoRepository.findAll();
	}

	public void insertarProyecto(@Valid Proyecto proyecto) {
		proyectoRepository.save(proyecto);
	}
	
	public Proyecto buscarProyectoId(Long id) {
		return proyectoRepository.findById(id).get();
	}

	public void eliminarProyecto(Long id) {
		proyectoRepository.deleteById(id);
	}

	public void eliminarProyectoObj(Proyecto proyecto) {
		proyectoRepository.delete(proyecto);
	}
	
}
