package com.flp.ems.view;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.util.Validate;

public class UserInteraction {
	//int temp;
	String s,temp;int flag=0;
	EmployeeServiceImpl service = new EmployeeServiceImpl();
	HashMap<String,String> hm=null;
	Scanner scan = new Scanner(System.in);
	private String KinID;
	private String Name;
	private String EmailID;
	List<HashMap<String,String>> mapList;
	public void AddEmployee(){
		flag=0;
		hm = new HashMap<String,String>();
		System.out.println("Enter Name");
		s=scan.nextLine();
		while(flag==0){
		if(Validate.validateName(s)==true){
		hm.put("Name",s);flag=1;
		}
		else{
			System.out.println("Enter Name");
			s=scan.nextLine();
		}
		}
		flag=0;
		
		System.out.println("Enter Phone_no");
		s=scan.next();
		hm.put("PhoneNumber", s);
		
		///s=scan.next();
		System.out.println("Enter adress");
		s=scan.next();
		hm.put("Adress",s); //bug if u put nextLine then problem comes it skips this line
		
		System.out.println("Enter date of birth");
		s=scan.next();
		while(flag==0){
			if(Validate.validateDate(s)==true){
				hm.put("DateOfBirth",s);
				flag=1;
			}
			else{
				System.out.println("Enter date of birth");
				s=scan.next();
			}
			}
		
		flag=0;
		System.out.println("Enter date of joining");
		s=scan.next();
		while(flag==0){
			if(Validate.validateDate(s)==true){
				hm.put("DateOfJoining",s);
				flag=1;
			}
			else{
				System.out.println("Enter date of joining");
				s=scan.next();
			}
			}
		
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
		hm = new HashMap<String,String>();
		System.out.println("Enter the 1.KinId or 2.Name or 3.EmailID Employee you want to modify: ");
		int temp=scan.nextInt();
		System.out.println("Enter the String value");
		s=scan.next();
		if(temp==1){
			hm.put("KinID",s);
			hm.put("Name","-");
			hm.put("EmailID","-");
		}else if(temp==2){
			hm.put("Name",s);
			hm.put("EmailID","-");
			hm.put("KinID","-");
		}else{
			hm.put("EmailID",s);
			hm.put("KinID","-");
			hm.put("Name","-");
		}
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
		System.out.println("Enter the KinID of Employee you want to search : ");
		KinID=scan.next();
		System.out.println("Enter the Name of Employee you want to search : ");
		Name=scan.next();
		System.out.println("Enter the EmailID of Employee you want to search : ");
		EmailID=scan.next();
		hm=service.SearchEmployee(KinID,Name,EmailID);
		for (String key: hm.keySet()){
            String value = hm.get(key);  
            System.out.println(key + " " + value);  
} 
	//irth")+" "+hm.get("DateOfJoining")+" "+hm.get("Adress")+" "+hm.get("DepartmentID")+" "+hm.get("ProjectID")+" "+hm.get("RoleID"));
	}
	public void getAllEmployee(){
		mapList=service.getAllEmployee();
		for(int i=0;i<mapList.size();i++){
			hm=mapList.get(i);
			for (String key: hm.keySet()){
	            String value = hm.get(key);  
	            System.out.println(key + " : " + value);  
	}
			System.out.println();
		}
	}
}
