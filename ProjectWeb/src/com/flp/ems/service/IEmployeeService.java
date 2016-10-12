package com.flp.ems.service;

import java.util.HashMap;
import java.util.List;

public interface IEmployeeService {
	public void AddEmployee(HashMap<String, String> hm);
	public void ModifyEmployee(HashMap<String, String> hm);
	public void RemoveEmployee(String id);
	public HashMap<String,String> SearchEmployee(String KinID,String Name,String EmailID);
	public List<HashMap<String,String>> getAllEmployee();
}