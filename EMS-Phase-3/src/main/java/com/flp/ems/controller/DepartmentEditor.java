package com.flp.ems.controller;

import java.beans.PropertyEditorSupport;

import com.flp.ems.dao.EmployeeSupportDetails;
import com.flp.ems.domain.Department;

public class DepartmentEditor extends PropertyEditorSupport {
	
	EmployeeSupportDetails details;
	
	public DepartmentEditor(EmployeeSupportDetails details) {
		this.details=details;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Department d=new Department();
		
		d=details.getDepartment(text);
		
		this.setValue(d);
	}
	
}
