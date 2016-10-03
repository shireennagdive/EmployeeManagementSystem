package com.flp.ems.view;

import java.util.HashMap;
import java.util.Scanner;

import com.flp.ems.service.EmployeeServiceImpl;

public class UserInteraction {
	//int temp;
	String s,temp;
	EmployeeServiceImpl service = new EmployeeServiceImpl();
	
	Scanner scan = new Scanner(System.in);
	public void AddEmployee(){
		HashMap<String,String> hm = new HashMap<String,String>();
		System.out.println("Enter Name");
		s=scan.next();
		hm.put("Name",s);
		System.out.println("Enter Phone_no");
		s=scan.next();
		hm.put("PhoneNumber", s);
		System.out.println("Enter adress");
		s=scan.next();
		hm.put("Adress",s);
		System.out.println("Enter date of birth");
		s=scan.next();
		hm.put("DateOfBirth",s);
		System.out.println("Enter date of joining");
		s=scan.next();
		hm.put("DateOfJoining",s);
		System.out.println("Enter Department ID");
		s=scan.next();
		hm.put("DepartmentID",s);
		System.out.println("ProjectID"); //onhold dount hai..one dept many porjects den select
		s=scan.next();
		hm.put("ProjectID",s);
		System.out.println("Enter RoleID");
		s=scan.next();
		hm.put("RoleID",s);
		service.AddEmployee(hm);
		
	}
	public void ModifyEmployee(){
		HashMap<String,String> hm = new HashMap<String,String>();
		System.out.println("Enter the id of Employee you want to remove : ");
		s=scan.next();
		hm.put("KinID",s);
		System.out.println("Enter the Adress of Employee you want to change : ");
		s=scan.next();
		hm.put("Adress",s);
		System.out.println("Enter the PhoneNumber of Employee you want to change : ");
		s=scan.next();
		hm.put("PhoneNumber",s);
		System.out.println("Enter the ProjectID you want to change : ");
		s=scan.next();
		hm.put("ProjectID",s);
		service.ModifyEmployee(hm);
		
	}
	public void RemoveEmployee(){
		System.out.println("Enter the id of Employee you want to remove : ");
		temp=scan.next();
		service.RemoveEmployee(temp);
	}
	public void SearchEmployee(){
		System.out.println("Enter the id of Employee you want to search : ");
		temp=scan.next();
		service.SearchEmployee(temp);
		
	}
	public void getAllEmployee(){
		service.getAllEmployee();
	}
}
