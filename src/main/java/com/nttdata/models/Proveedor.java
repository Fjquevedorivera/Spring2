package com.nttdata.models;

public class Proveedor {
	
	// Attributes
	private String name;
	private String last_name;
	private String email;
	private String age;
	
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
