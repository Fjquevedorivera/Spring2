package com.nttdata.models;

public class Cliente {
	
	//Attributes: access lvl, type, name;
	//private Boolean plan = false;
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
	
	public Cliente(String rut, String name, Integer age, String sex, Boolean plan, String cell_phone) {
		super();
		this.rut = rut;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.plan = plan;
		this.cell_phone = cell_phone;
	}
	
	//Methods
	@Override
	public String toString() {
		return "Cliente [rut=" + rut + ", name=" + name + ", age=" + age + ", sex=" + sex + ", plan=" + plan
				+ ", cell_phone=" + cell_phone + "]";
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
	public String getCell_phone() {
		return cell_phone;
	}
	public void setCell_phone(String cell_phone) {
		this.cell_phone = cell_phone;
	}
	
}
