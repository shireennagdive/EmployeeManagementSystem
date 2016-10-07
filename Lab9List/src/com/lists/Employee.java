package com.lists;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Employee implements Comparable {

	public String firstName, lastName, grade, joining_month;

	protected int salary;
	public int empId;
	public Date d;
	protected static int count_emp=0;
	protected static int count_con=0;
	public void display(Employee e){
		System.out.println("Details : \n "+e.firstName+" "+e.lastName+" "+e.grade+" "+e.salary+" "+e.empId);
		
	}
	public Employee() {
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
		String input;
		Scanner scan = new Scanner(System.in);
		System.out
				.println("Enter your details : \n 1.FirstName \n 2.LastName \n 3.Grade \n 4.Joining Month\n");
		count_emp++;
		this.empId=count_emp;
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

	}@Override
	public int compareTo(Object o) {
	System.out.println("I am here");
		int diff=this.empId-((Employee)o).empId;
		return -diff;
	}
}