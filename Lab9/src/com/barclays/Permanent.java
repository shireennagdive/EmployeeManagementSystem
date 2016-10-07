package com.barclays;
//package com.capgemini;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Permanent extends Employee {
	private static int count = 0;

	public Permanent(int sal) {
		super();
		count++;
		this.empId = count;
		this.salary=sal;
	}

	public int getSalary() {
		return salary;
	}

	public static int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void display(Permanent e){
		System.out.println("Details : \n "+e.firstName+" "+e.lastName+" "+e.grade+" "+e.salary+" "+e.empId);
		
	}

}
