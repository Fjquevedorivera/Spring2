package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Usuario;

@Repository
//CrudRepocitory modelo y tipo de dato PK Long
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	//List<Usuario> findAll();
	
	//Obtener todos los clientes 
	@Query("SELECT u FROM Usuario u")//debe usar el nombre del objeto
	List<Usuario> findAllUsuarios();
	
	@Query("SELECT u.name FROM Usuario u")// retorna objeto de tipo string
	List<String> findAllUsuariosNombres();
	
	@Query("SELECT u.name, u.last_name FROM Usuario u")// retorna objeto de tipo string
	List<Object[]> findAllUsuariosNombresApellidos();
	
	@Query("SELECT u FROM Usuario u WHERE id = ?1")
	List<Usuario> getUsuarioById(Long id);
	
	@Query(value = "SELECT name, last_name FROM usuarios", nativeQuery = true)// utilizando entidad
	List<Object[]> findAllUsuariosNombresApellidosSQL();
	
	@Query(value = "SELECT * FROM usuarios WHERE rut = ?2 and id = ?1", nativeQuery = true)
	List<Usuario> getUsuarioByIdSQL(Long id, String rut);

}
