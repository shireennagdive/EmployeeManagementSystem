package com.flp.ems.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.flp.ems.dao.EmployeeDaoImplForDB;
import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Employee;

public class EmployeeServiceImpl implements IEmployeeService{

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date=null;
	EmployeeDaoImplForList dao = new EmployeeDaoImplForList();
	EmployeeDaoImplForDB dbdao = new EmployeeDaoImplForDB();
	public void AddEmployee(HashMap<String, String> hm){
		Employee emp = new Employee();
		emp.setName(hm.get("Name"));
		emp.setKin_Id(emp.getName()+Employee.getCount());
		emp.setAdress(hm.get("Adress"));
		emp.setEmail_id(emp.getName()+Employee.getCount()+"@barclays.com");
		emp.setPhone_no(Long.parseLong(hm.get("PhoneNumber")));
		emp.setDepartmentId(Integer.parseInt(hm.get("DepartmentID")));
		emp.setProjectID(Integer.parseInt(hm.get("ProjectID")));
		emp.setRoleID(Integer.parseInt(hm.get("RoleID")));
		try {
			date=dateFormat.parse(hm.get("DateOfBirth"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emp.setDateofbirth(date);
		try {
			date=dateFormat.parse(hm.get("DateOfJoining"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emp.setDateofjoin(date);
		dbdao.AddEmployee(emp);
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
		dbdao.RemoveEmployee(temp);
	}
	public void SearchEmployee(String temp){
		dbdao.SearchEmployee(temp); //comparator
	}
	public void getAllEmployee(){
		dbdao.getAllEmployee();
	}
	 
}
