package com.nttdata.models;

public class Celular {
	
	// Attributes
	private String phone;
	private String brand;
	
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
