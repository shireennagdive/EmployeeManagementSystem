package com.barclays;

//package com.capgemini;

import java.util.*;
import java.text.*;
import java.io.*;

public class Employee {

	public String firstName, lastName, grade, joining_month;

	protected int salary;
	public int empId;
	public Date d;
	
	public void display(Employee e){
		System.out.println("Details : \n "+e.firstName+" "+e.lastName+" "+e.grade+" "+e.salary+" "+e.empId);
		
	}
	public Employee() {
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
		String input;
		Scanner scan = new Scanner(System.in);
		System.out
				.println("Enter your details : \n 1.FirstName \n 2.LastName \n 3.Grade \n 4.Joining Month\n");

		this.firstName = scan.next();
		this.lastName = scan.next();
		this.grade = scan.next();
		input = scan.next();
		try {
			this.d = ft.parse(input);
			System.out.println(this.d);
		} catch (ParseException ex) {
			System.out.println("Unparseable using " + ft);
		}

	}

}
