package com.nttdata.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity //representación de la entidad
@Table(name="clientes") // nombre de la tabla en la BD
public class Cliente {
	
	//Attributes: access lvl, type, name;
	//private Boolean plan = false;
	@Id //clave primaria o PK
	@GeneratedValue(strategy= GenerationType.IDENTITY) // auto incrementable	
	private Long id;
	private String rut;
	private String name;
	private Integer age;
	private String sex;
	private Boolean plan;
	private String phone;
	
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	
	// Relación nan
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "clientes_proveedores", // Tabla intermedia
		joinColumns = @JoinColumn(name="cliente_id"), // Nombre posicionado
		inverseJoinColumns = @JoinColumn(name="proveedor_id") // Nombre refereciado
	)
	private List<Proveedor> proveedor;
	
	public List<Proveedor> getProveedor() {
		return proveedor;
	}

	public void setProveedor(List<Proveedor> proveedor) {
		this.proveedor = proveedor;
	}

	//Constructors: permiten instanciar la clase, 
	//asignado un espacio de memoria y su información. 
	public Cliente() {
		super();
	}
	
	public Cliente(String rut, String name, Integer age, String sex, Boolean plan, String phone) {
		super();
		this.rut = rut;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.plan = plan;
		this.phone = phone;
	}
	
	//Methods
	@Override
	public String toString() {
		return "Cliente [rut=" + rut + ", name=" + name + ", age=" + age + ", sex=" + sex + ", plan=" + plan
				+ ", phone=" + phone + "]";
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//Getters and Setters 
	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Boolean getPlan() {
		return plan;
	}
	public void setPlan(Boolean plan) {
		this.plan = plan;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@PrePersist
    protected void onCreated(){
        this.createdAt = new Date();
    }
	
    @PreUpdate
    protected void onUpdated(){
        this.updatedAt = new Date();
    }
	
}
