package com.flp.ems.view;

import java.util.Scanner;

public class BootClass {
	UserInteraction u = new UserInteraction();
	
	public static void main(String args[]){
	BootClass b = new BootClass();
	b.menuSelection();
	}
	public void menuSelection(){
		int n,times;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of times you want to operate : ");
		times=scan.nextInt();
		while(times>0){
		System.out.println("Enter which operation you want to perform :"
				+ "1.AddEmployee\n 2.ModifyEmployee\n3.RemoveEmployee\n4.SearchEmployee\n5.getAllEmployee");
		n=scan.nextInt();
		if(n==1){
			u.AddEmployee();
		}else if(n==2){
			u.ModifyEmployee();
		}else if(n==3){
			u.RemoveEmployee();
		}else if(n==4){
			u.SearchEmployee();
		}else if(n==5){
			u.getAllEmployee();
		}else{
			
		}
		times--;
		} //modify remove search nai chalraha
		System.out.println("Thankyou");
		scan.close();
	}
}
