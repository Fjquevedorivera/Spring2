package com.nttdata.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
}
