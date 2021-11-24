package com.nttdata.services;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Usuario;
import com.nttdata.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public void insertarUsuario(@Valid Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> obtenerListaUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarUsuarioId(Long id) {
		return usuarioRepository.findById(id).get();
	}

	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	public void eliminarUsuarioObj(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
}
