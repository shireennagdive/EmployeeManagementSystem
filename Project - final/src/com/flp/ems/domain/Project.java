package com.flp.ems.domain;

public class Project {
	static int project_id=0;
	String name,description;
	public Project() {
		project_id++;
		// TODO Auto-generated constructor stub
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
