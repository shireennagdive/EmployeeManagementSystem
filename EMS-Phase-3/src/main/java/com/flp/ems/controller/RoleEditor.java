package com.flp.ems.controller;

import java.beans.PropertyEditorSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.flp.ems.dao.EmployeeSupportDetails;
import com.flp.ems.domain.Role;

public class RoleEditor extends PropertyEditorSupport {
	
	EmployeeSupportDetails details;
	
	public RoleEditor(EmployeeSupportDetails details) {
		this.details=details;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Role r=new Role();
		
		r=details.getRole(text);
		
		this.setValue(r);
	}
}