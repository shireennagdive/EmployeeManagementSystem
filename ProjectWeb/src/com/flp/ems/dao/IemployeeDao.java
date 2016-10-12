package com.flp.ems.dao;

import java.util.List;

import com.flp.ems.domain.Employee;

public interface IemployeeDao {
    
	public void AddEmployee(Employee e);
	public void ModifyEmployee(Employee e);
	public void RemoveEmployee(String id);
	public Employee SearchEmployee(String KinID,String Name,String EmailID );
	public List<Employee> getAllEmployee();
}