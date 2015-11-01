package com.keepthinker.smm.entity;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = -3436645689896755989L;
	private int id;
	private String name;
	
	public Person(){
	}
	
	public Person(String name) {
		super();
		this.name = name;
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
	
	
}
