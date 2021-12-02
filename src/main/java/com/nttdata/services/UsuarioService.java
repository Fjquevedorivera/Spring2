package com.nttdata.services;

import javax.validation.Valid;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nttdata.models.Cliente;
import com.nttdata.models.Usuario;
import com.nttdata.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	BCryptPasswordEncoder bcpe;
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public Usuario persistirUsuarioRol(Usuario usuario) {
		usuario.setPassword(bcpe.encode(usuario.getPassword()));
		usuario.setRoles(roleService.getListRole("ROLE_USER"));
		return usuarioRepository.save(usuario);
	}
	
	public Usuario registroUsuario(Usuario usuario) {
		String hashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		//set hashing password
		usuario.setPassword(hashed);
		return usuarioRepository.save(usuario);
	}
	
	public void insertarUsuario(@Valid Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public void actualizarUsuario(@Valid Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> obtenerListaUsuarios() {
		//return usuarioRepository.findAll();
		return usuarioRepository.findAllUsuarios();
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
	
	public List<String> getUsuariosNombres() {
		return usuarioRepository.findAllUsuariosNombres();
	}
	
	public List<Object[]> getUsuariosNombresApellidos() {
		return usuarioRepository.findAllUsuariosNombresApellidos();
	}
	
	public List<Object[]> getUsuariosNombresApellidosSQL() {
		return usuarioRepository.findAllUsuariosNombresApellidosSQL();
	}
	
	public List<Usuario> getUsuarioById(Long id) {
		return usuarioRepository.getUsuarioById(id);
	}
	
	public boolean loginUsuario(String email, String password) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario == null) {
			return false;
		} else {
//			if(password.equals(usuario.getPassword())) {
			if(BCrypt.checkpw(password, usuario.getPassword())) {
				return true;
			} else {
				return false;
			}
		} 

	}
	
	public Usuario findByName(String nombre) {
		return usuarioRepository.findByName(nombre);
	}
}
