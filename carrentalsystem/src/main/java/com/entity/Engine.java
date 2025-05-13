package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Engine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Type;
	 private double Cc;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public double getCc() {
		return Cc;
	}
	public void setCc(double cc) {
		Cc = cc;
	}
	@Override
	public String toString() {
		return "Engine [Id=" + Id + ", Type=" + Type + ", Cc=" + Cc + "]";
	}
	 
}
