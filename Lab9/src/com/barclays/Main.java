package com.barclays;

//package com.capgemini;

import java.util.*;
import java.text.*;
import java.io.*;

class Main {

	public static void main(String args[]) {

		Test t = new Test();
		Scanner scan = new Scanner(System.in);
		int reply = 1, reply2 = 1,rate,hours,sal,i=-1,j=-1,test=0;
		String name="";
		Permanent emp[] = new Permanent[10];
		//Map<Integer,String> emp1 = new TreeMap<>();
		ContractBased con[] = new ContractBased[10];
		//Map<Integer,String> con1 = new TreeMap<>();
		while (reply == 1) {

			System.out.println("Do you want to create a new Employee?1/0");
			reply = scan.nextInt();

			if (reply == 1) {
				System.out.println("Do you want to create a Permanent Employee or ContractBased?1/0");
				reply2 = scan.nextInt();
				if (reply2 == 1) {
					System.out.println("5.Salary");
					sal=scan.nextInt();
					i++;
					//String s=emp1.put(i,name);
					
					emp[i] = new Permanent(sal);
					emp[i].display(emp[i]);

				} else {
					System.out.println("Name of Contractor");
					name=scan.next();
					System.out.println("Rate and Hours");
					rate=scan.nextInt();
					hours=scan.nextInt();
					j++;
					con[j] = new ContractBased(name);
					con[j].setSalary(rate, hours);
					con[j].display(con[j]);
				}
				// System.out.println("Name is : " + emp.firstName + " " +
				// emp.lastName + " Id is : " + emp.empId);
			}else{
				reply=0;
			}

		}
		test=1;
		while(test==1){
		System.out.println("Do you want to test?1/0");
		test=scan.nextInt();
		if(test==1)
		t.test(emp, con);
		else{
		test=0;	
		}
		}
		System.out.println("Total Permanent employees are : " + Permanent.getCount());
		System.out.println("Total ContractBased employees are : " + ContractBased.getCount());
		

	}

}