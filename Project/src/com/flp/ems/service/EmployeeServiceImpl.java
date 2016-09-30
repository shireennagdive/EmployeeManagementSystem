package com.flp.ems.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Employee;

public class EmployeeServiceImpl implements IEmployeeService{

	EmployeeDaoImplForList dao = new EmployeeDaoImplForList();
	public void AddEmployee(HashMap<String, String> hm){
		Employee emp = new Employee();
		emp.setName(hm.get("Name"));
		emp.setKin_Id(emp.getName()+Employee.getCount());
		emp.setAdress(hm.get("Adress"));
		emp.setEmail_id(emp.getName()+Employee.getCount()+"@barclays.com");
		emp.setPhone_no(Long.parseLong(hm.get("PhoneNumber")));
		emp.setDateofbirth(hm.get("DateOfBirth"));
		emp.setDateofjoin(hm.get("DateOfJoining"));
		dao.AddEmployee(emp);
		
	}
	public void ModifyEmployee(HashMap<String, String> hm){
		Employee e = dao.search(hm.get("kinID"));
		e.setAdress(hm.get("Adress"));
		e.setPhone_no(Long.parseLong(hm.get("PhoneNumber")));
		dao.ModifyEmployee(e);
		/*List<Employee> list = dao.getList();
		Iterator<Employee> it = list.iterator();
		for(Employee e : list){
			System.out.println("id is : "+hm.get("KinID"));
			if(hm.get("KinID").equals(e.getKin_Id())){
				System.out.println("in equals");
				
			}
		}*/
	}
	public void RemoveEmployee(String temp){
		dao.RemoveEmployee(temp);
	}
	public void SearchEmployee(String temp){
		dao.SearchEmployee(temp); //comparator
	}
	public void getAllEmployee(){
		dao.getAllEmployee();
	}
	 
}
