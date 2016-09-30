package com.flp.ems.service;

import java.util.HashMap;

public interface IEmployeeService {
	public void AddEmployee(HashMap<String, String> hm);
	public void ModifyEmployee(HashMap<String, String> hm);
	public void RemoveEmployee(String id);
	public void SearchEmployee(String id);
	public void getAllEmployee();
}
