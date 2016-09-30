package com.flp.ems.dao;

import com.flp.ems.domain.Employee;

public interface IemployeeDao {
    
	public void AddEmployee(Employee e);
	public void ModifyEmployee(Employee e);
	public void RemoveEmployee(String id);
	public void SearchEmployee(String id);
	public void getAllEmployee();
}
