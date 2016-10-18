package com.flp.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flp.ems.dao.IemployeeDao;
import com.flp.ems.domain.Employee;

@Service
public class EmployeeServiceImpl  implements IEmployeeService{

	@Autowired
	private IemployeeDao employeeDao;

	@Override
	@Transactional
	public void AddEmployee(Employee employee) {
		employeeDao.AddEmployee(employee);
		
	}

	@Override
	@Transactional
	public void ModifyEmployee(Employee employee) {
		employeeDao.ModifyEmployee(employee);
	}

	@Override
	@Transactional
	public void RemoveEmployee(int[] id) {
		employeeDao.RemoveEmployee(id);
	}

	@Override
	@Transactional
	public Employee SearchEmployee(int id) {
		return employeeDao.SearchEmployee(String.valueOf(id));
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}
}
