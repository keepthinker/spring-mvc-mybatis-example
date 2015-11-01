package com.keepthinker.smm.entity;

import java.io.Serializable;

public class Animal implements Serializable{
	
	private static final long serialVersionUID = -4767977228979926641L;
	
	int id;
	String name;
	String type;
	
	public Animal() {
	}

	public Animal(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
}
