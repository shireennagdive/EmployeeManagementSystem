package com.flp.ems.service;

import java.util.List;

import com.flp.ems.domain.Employee;

public interface IEmployeeService {
	public void AddEmployee(Employee employee);
	public void ModifyEmployee(Employee employee);
	public void RemoveEmployee(int[] id);
	public Employee SearchEmployee(int id);
	public List<Employee> getAllEmployee();
}
