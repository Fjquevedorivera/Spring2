package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Usuario;

@Repository
//CrudRepocitory modelo y tipo de dato PK Long
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	List<Usuario> findAll(); 
	
}
