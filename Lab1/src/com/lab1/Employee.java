package com.lab1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Employee {
	private static int count;
	String firstName, lastName, grade, joining_month;
	

	int salary, empId;
	Date d;

	public static int getCount() {
		return Employee.count;
	}

	public static void setCount(int count) {
		Employee.count = count;
	}

	public static Employee create() {
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
		String input;
		Scanner scan = new Scanner(System.in);
		Employee e = new Employee();

		Employee.setCount(count++);
		System.out
				.println("Enter your details : \n 1.FirstName \n 2.LastName \n 3.Grade \n 4.Joining Month\n 5.Salary");

		e.firstName = scan.next();
		e.lastName = scan.next();
		e.grade = scan.next();
		input = scan.next();
		e.salary = scan.nextInt();
		e.empId = count;
		try {
			e.d = ft.parse(input);
			System.out.println(e.d);
		} catch (ParseException ex) {
			System.out.println("Unparseable using " + ft);
		}
		scan.close();
		return e;
	}

}
