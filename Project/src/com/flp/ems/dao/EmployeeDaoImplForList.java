package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForList implements IemployeeDao {
	//EmployeeDaoImplForList dao = new EmployeeDaoImplForList();
	List<Employee> list = new ArrayList<Employee>();
	Iterator<Employee> it = list.iterator();
	
	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}
	
	public void AddEmployee(Employee e){
	list.add(e);
	this.getAllEmployee();                             
    }
	
	public void ModifyEmployee(Employee e){
		String c=e.getKin_Id();
		int flag=0;
		for(int i=0; i<list.size() && flag==0; i++) {
	        if(list.get(i).getKin_Id().equals(c)) {                
	            System.out.println("in modify");
	            list.set(i, e);
	            flag=1;
	        }
	    }
		this.getAllEmployee();
	}
	
	public void RemoveEmployee(String temp){
		int flag=0;
		//String c=e.getKin_Id();
		for(int i=0; i<list.size(); i++) {
	        //here is maybe fine to deal with integerList.get(i)==null
	        if(list.get(i).getKin_Id().equals(temp)) {                
	            list.remove(i);
	        }
	    }
		this.getAllEmployee();
	} 
	
	public void SearchEmployee(String id){
		int flag=0;
		for(Employee e : list){
			if(e.getKin_Id().equals(id)){
				flag=1;
				System.out.println("Details are : \n");
				System.out.println(e.getName()+" "+e.getAdress()+" "+e.getDateofbirth()+" "+e.getDateofjoin()+" "+e.getEmail_id()+" "+e.getKin_Id()+" "+e.getPhone_no());
			}
		}
		if(flag==0){
			System.out.println("not found");
		}
		
	}
	public void getAllEmployee(){
		if(list.isEmpty()){
			System.out.println("Empty");
		}else{
		for(Employee e : list){
			System.out.println(e.getEmp_Id()+" "+e.getName()+" "+e.getAdress()+" "+e.getDateofbirth()+" "+e.getDateofjoin()+" "+e.getEmail_id()+" "+e.getKin_Id()+" "+e.getPhone_no());
		}
		}
	}
	public Employee search(String kinID){
		int flag=0,index=0;
		for(int i=0;i<list.size() && flag==0;i++){
			if(list.get(i).getKin_Id().equals(kinID)){
				//return list.get(i);
				index=i;flag=1;
			}
		}
		return list.get(index);
	}
	
}
