package com.genesis;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {

	@Id
	private int regno;
	private String brand;
	private String model;
	private float price;
	
	public Vehicle() {
	}

	public Vehicle(int regno) {
		this.regno = regno;
	}

	public Vehicle(int regno, String brand, String model, float price) {
		this.regno = regno;
		this.brand = brand;
		this.model = model;
		this.price = price;
	}

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehicle [regno=" + regno + ", brand=" + brand + ", model=" + model + ", price=" + price + "]";
	}
	
	
	
}
