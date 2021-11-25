package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Proyecto;

@Repository
public interface ProyectoRepository extends CrudRepository<Proyecto, Long>{
	List<Proyecto> findAll();
}
