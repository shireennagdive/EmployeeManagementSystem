package com.flp.ems.domain;

public class Employee {
	private static int count=0;
//	private int Emp_Id;
	public Employee() {
		count++;
	}
	private String Name,kin_Id,email_id,adress,dateofjoin,dateofbirth;
	public String getDateofjoin() {
		return dateofjoin;
	}
	public void setDateofjoin(String dateofjoin) {
		this.dateofjoin = dateofjoin;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
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
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
 }
