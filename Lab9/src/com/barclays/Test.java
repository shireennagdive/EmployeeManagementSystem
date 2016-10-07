package com.barclays;

import java.util.Scanner;

class Test {
	Scanner scan = new Scanner(System.in);
	int id,reply;
	public void test(Permanent p[],ContractBased c[]){
		System.out.println("Enter Employee you want to check\n1.Permanent\n2.ContractBased\n");
		reply=scan.nextInt();
		if(reply==1){
			try {
				checkID(p);
			} catch (EmployeeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				checkID(c);
			} catch (EmployeeNotFoundException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		}
		
	}
	
	public void checkID(Permanent p[]) throws EmployeeNotFoundException{
		System.out.println("Enter ID to be checked\n");
		id=scan.nextInt();
		if(id<=Permanent.getCount()){ //
			p[id-1].display(p[id-1]);
		}
		else{
			throw new EmployeeNotFoundException();
		}
	}

	public void checkID(ContractBased p[]) throws EmployeeNotFoundException{
    	System.out.println("Enter ID to be checked\n");
		id=scan.nextInt();
		if(id<=ContractBased.getCount()){
			p[id-1].display(p[id-1]);
		}else{
			throw new EmployeeNotFoundException();
		}
	}
	
}
