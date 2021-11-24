package com.nttdata.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //representación de la entidad
@Table(name="usuarios") // nombre de la tabla en la BD
public class Usuario {
	
	@Id //clave primaria o PK
	@GeneratedValue(strategy= GenerationType.IDENTITY) // auto incrementable	
	private Long id;
	
	private String name;
	private String last_name;
	private String limite;
	private String cp;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String name, String last_name, String limite, String cp) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.limite = limite;
		this.cp = cp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getLimite() {
		return limite;
	}

	public void setLimite(String limite) {
		this.limite = limite;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Usuario [name=" + name + ", last_name=" + last_name + ", limite=" + limite + ", cp=" + cp + "]";
	}
	
	
	
}
