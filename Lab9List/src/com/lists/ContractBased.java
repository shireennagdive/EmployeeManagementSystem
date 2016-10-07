package com.lists;


public class ContractBased extends Employee {
	private static int count=0;
	public String nameOfCon;

	public ContractBased(String nameofcon) {
		super();
		count++;
		this.nameOfCon = nameofcon;
		this.empId=count;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int rateperhour, int hours) {
		this.salary = rateperhour * hours;
	}

	public static int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void display(ContractBased e){
	System.out.println("Details : \n "+e.firstName+" "+e.lastName+" "+e.grade+" "+e.salary+" "+e.empId);
	
}
}