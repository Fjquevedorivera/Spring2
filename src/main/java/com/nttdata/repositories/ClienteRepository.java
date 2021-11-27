package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	// Con Crud Repository
	//List<Cliente> findAll();
	
	//Obtener todos los clientes JPQL
	@Query("SELECT c FROM Cliente c")//debe usar el nombre del objeto
	List<Cliente> findAllClientes();
}
