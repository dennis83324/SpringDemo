package com.example.demo;

import java.util.List;

import javax.validation.constraints.NotNull;

public class Student {
	
	@NotNull
	Integer id;
	
	String name;
	Double	score;
	boolean graduated;
	Integer age;
	List<String> courseList;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
