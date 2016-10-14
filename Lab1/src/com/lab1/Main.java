package com.lab1;


import java.util.*;
import java.text.*;
import java.io.*;

class Main {

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		int reply = 1;

		while (reply == 1) {

			System.out.println("Do you want to create a new Employee?1/0");
			reply = scan.nextInt();

			if (reply == 1) {
				Employee emp = Employee.create();
				System.out.println("Name is : " + emp.firstName + " " + emp.lastName + " Id is : " + emp.empId);
			}

		}

		System.out.println("Total employees are : " + Employee.getCount());

	}

}