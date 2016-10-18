package com.flp.ems.dao;

import java.util.List;

import com.flp.ems.domain.Employee;

public interface IemployeeDao {
	public void AddEmployee(Employee emp);
	public void ModifyEmployee(Employee emp);
	public void RemoveEmployee(int[] id);
	public Employee SearchEmployee(String id);
	public List<Employee> getAllEmployee();
}
