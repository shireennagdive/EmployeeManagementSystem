package com.flp.ems.domain;

import java.util.Date;

public class Employee {
	private static int count=0;
	private int Emp_Id;
	public Employee() {
		count++;
		Emp_Id=count;
	}
	int DepartmentId,ProjectID,RoleID;
	
	private String Name,kin_Id,email_id,adress;
	Date dateofjoin;
	Date dateofbirth;
	public int getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(int departmentId) {
		DepartmentId = departmentId;
	}
	public int getProjectID() {
		return ProjectID;
	}
	public void setProjectID(int projectID) {
		ProjectID = projectID;
	}
	public int getRoleID() {
		return RoleID;
	}
	public void setRoleID(int roleID) {
		RoleID = roleID;
	}
	public Date getDateofjoin() {
		return dateofjoin;
	}
	public void setDateofjoin(Date dateofjoin) {
		this.dateofjoin = dateofjoin;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public int getEmp_Id() {
		return Emp_Id;
	}
	public void setDateofbirth(Date date) {
		this.dateofbirth = date;
	}
	private long phone_no;
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	public static int getCount() {
		return count;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getKin_Id() {
		return kin_Id;
	}
	public void setKin_Id(String kin_Id) {
		this.kin_Id = kin_Id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}
	public void setEmpID(int int1) {
		this.Emp_Id=Emp_Id;
		
	}
 }
