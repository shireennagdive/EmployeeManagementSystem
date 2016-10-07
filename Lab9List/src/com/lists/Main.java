package com.lists;


	//package com.capgemini;

	import java.util.*;
	import java.text.*;
	import java.io.*;

	class Main {

		public static int count=0;
		public static void main(String args[]){
		/*
		 * this is done by treeset //employee wala
		 * Map<EmpKey,Employee> emp = new TreeMap<EmpKey,Employee>();
		Map<Integer,String> con = new TreeMap<>();
		String name,value;
		int n,i=0,id,temp;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of employees");
		n=scan.nextInt();
		while(i<n){
			count++;
			System.out.println("Enter id");
			temp=scan.nextInt();
			System.out.println("Enter suffix");
			name=scan.next();
			emp.put(new EmpKey(temp,name),new Employee());
		i++;
		}
		Set<Map.Entry<EmpKey, Employee>> set = emp.entrySet();
		for(Map.Entry<EmpKey, Employee> e : set){
			System.out.println(e.getKey().id+" "+e.getValue().firstName);
		}
		System.out.println("Enter id you want to search\n");
		id=scan.nextInt();
		Employee e=emp.get(id);
		if(e!=null){
			System.out.println(e.empId+" "+e.firstName+" "+e.grade);
		}else{
			try {
				throw new EmployeeNotFoundException();
			} catch (EmployeeNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		}
*/
			int n,i=0,temp;
			String name;
			Scanner scan = new Scanner(System.in);
			EmpKey a[]={null,null};
			HashMap<EmpKey,Employee> hm = new HashMap<EmpKey,Employee>();
			System.out.println("Enter number of employees");
			n=scan.nextInt();
			while(i<n){
				count++;
				System.out.println("Enter id");
				temp=scan.nextInt();
				System.out.println("Enter suffix");
				name=scan.next();
				i++;
				a[i-1]=new EmpKey(temp,name);
				hm.put(a[i-1],new Employee());
				System.out.println("initially : "+a[i-1].hashCode());
		}
			Set<Map.Entry<EmpKey, Employee>> set = hm.entrySet();
			/*for(Map.Entry<EmpKey, Employee> e : set){
				System.out.println(e.getKey().id+ " "+e.getValue().firstName);
			}*/
			//search
			Employee e = hm.get(new EmpKey(12,"shireen"));
			System.out.println("id is : "+e.firstName);
			/*Employee e = hm.get(a[0]);
			System.out.println("details : "+e.empId+" "+e.firstName);
			Employee e1 = hm.get(a[1]);
			System.out.println("details : "+e1.empId+" "+e1.firstName);
			*/
			
		}
		
	}
