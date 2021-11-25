package com.nttdata.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //representación de la entidad
@Table(name="celulares") // nombre de la tabla en la BD
public class Celular {
	
	// Attributes
	@Id //clave primaria o PK
	@GeneratedValue(strategy= GenerationType.IDENTITY) // auto incrementable	
	private Long id;
	
	private String phone;
	private String brand;
	
	// Relación 1a1
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// Constructors
	public Celular() {
		super();
	}

	public Celular(String phone, String brand) {
		super();
		this.phone = phone;
		this.brand = brand;
	}
	
	//Method
	@Override
	public String toString() {
		return "Celular [phone=" + phone + ", brand=" + brand + "]";
	}
	
	// Getters and Setters
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}
