package com.flp.ems.domain;

public class Role {
	static int Role_id;
	String name,description;
	public Role(){
		Role_id++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}