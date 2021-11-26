package com.nttdata.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity // representación de la entidad
@Table(name="proveedores")// nombre de la tabla en la BD
public class Proveedor {
	
	// Attributes
	@Id // clave primaria o PK
	@GeneratedValue(strategy= GenerationType.IDENTITY) // auto incrementable	
	private Long id;
	
	private String name;
	private String last_name;
	private String email;
	private String age;
	
	// Relación nan
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "clientes_proveedores", // Tabla intermedia
		joinColumns = @JoinColumn(name="proveedor_id"), // Nombre posicionado
		inverseJoinColumns = @JoinColumn(name="cliente_id") // Nombre refereciado
	)
	private List<Cliente> clientes;
	
	// Constructors
	public Proveedor() {
		super();
	}

	public Proveedor(String name, String last_name, String email, String age) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.email = email;
		this.age = age;
	}
	
	// Getters and Setters
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	// Method
	@Override
	public String toString() {
		return "Proveedor [name=" + name + ", last_name=" + last_name + ", email=" + email + ", age=" + age + "]";
	}
		
}
