package com.flp.ems.domain;

public class Department {
static int	department_id=0;
private String name,description;
public Department(){
	department_id++;
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
