package com.flp.ems.controller;

import java.beans.PropertyEditorSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.flp.ems.dao.EmployeeSupportDetails;
import com.flp.ems.domain.Department;
import com.flp.ems.domain.Project;

public class ProjectEditor extends PropertyEditorSupport {
	
	EmployeeSupportDetails details;
	
	public ProjectEditor(EmployeeSupportDetails details) {
		this.details=details;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Project p=new Project();
		
		p=details.getProject(text);
		
		this.setValue(p);
	}
}