package com.flp.ems.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.flp.ems.dao.EmployeeDaoImplForDB;
//import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Employee;

public class EmployeeServiceImpl implements IEmployeeService{

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date=null;
	//EmployeeDaoImplForList dao = new EmployeeDaoImplForList();
	EmployeeDaoImplForDB dbdao = new EmployeeDaoImplForDB();
	List<Employee> empList;
	Employee emp=null;
	HashMap<String,String> hm;
	List<HashMap<String,String>> mapList = null;
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
		System.out.println();
		Employee e = dbdao.SearchEmployee(hm.get("KinID"),hm.get("Name"),hm.get("EmailID"));
		System.out.println("in service e is : "+e);
		e.setAdress(hm.get("Adress"));
		e.setPhone_no(Long.parseLong(hm.get("PhoneNumber")));
		dbdao.ModifyEmployee(e);
		
	}
	public void RemoveEmployee(String temp){
		dbdao.RemoveEmployee(temp);
	}
	public HashMap<String,String> SearchEmployee(String KinID,String Name,String EmailID){
		hm=new HashMap<String,String>();
		emp=dbdao.SearchEmployee(KinID,Name,EmailID); //comparator
		hm.put("EmployeeID",String.valueOf(emp.getEmp_Id()));
		hm.put("Name", emp.getName());
		hm.put("KinID",emp.getKin_Id());
		hm.put("EmailID",emp.getEmail_id());
		hm.put("PhoneNumber",String.valueOf(emp.getPhone_no()));
		hm.put("DateOfBirth",dateFormat.format(emp.getDateofbirth()));
		hm.put("DateOfJoining",dateFormat.format(emp.getDateofjoin()));
		hm.put("Adress",emp.getAdress());
		hm.put("DepartmentID",String.valueOf(emp.getDepartmentId()));
		hm.put("ProjectID",String.valueOf(emp.getProjectID()));
		hm.put("RoleID",String.valueOf(emp.getRoleID()));
		return hm;
	}
	
	public List<HashMap<String,String>> getAllEmployee(){
		//empList=new ArrayList<Employee>();
		empList=dbdao.getAllEmployee();
		mapList = new ArrayList<HashMap<String,String>>();
		
		for(int i=0;i<empList.size();i++){
			emp=empList.get(i);
			hm = new HashMap();
			hm.put("EmployeeID",String.valueOf(emp.getEmp_Id()));
			hm.put("Name", emp.getName());
			hm.put("KinID",emp.getKin_Id());
			hm.put("EmailID",emp.getEmail_id());
			hm.put("PhoneNumber",String.valueOf(emp.getPhone_no()));
			hm.put("DateOfBirth",(String)dateFormat.format(emp.getDateofbirth()));
			hm.put("DateOfJoining",(String)dateFormat.format(emp.getDateofjoin()));
			hm.put("Adress",emp.getAdress());
			hm.put("DepartmentID",String.valueOf(emp.getDepartmentId()));
			hm.put("ProjectID",String.valueOf(emp.getProjectID()));
			hm.put("RoleID",String.valueOf(emp.getRoleID()));
			mapList.add(hm);
		}	
	return mapList; 
	}
	
}