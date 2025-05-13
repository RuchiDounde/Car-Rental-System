package com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class Car {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY, generator="car_id")
@SequenceGenerator(name="car_id",initialValue=100,allocationSize=1)
	private int Id;
	 private String Brand;
	 private String Model;
	 private LocalDate registerDate;
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	
	@OneToOne
	private Engine engine;
	
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	@Override
	public String toString() {
		return "Car [Id=" + Id + ", Brand=" + Brand + ", Model=" + Model + ", registerDate=" + registerDate
				+ ", engine=" + engine + "]";
	}
	 
}
