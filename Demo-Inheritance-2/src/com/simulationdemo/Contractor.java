package com.simulationdemo;

public class Contractor {
	private String name="Suhas";
	private int cbCount;
	
	
	public class CBEmployee{
		private String name;
		
		public CBEmployee() {
			this.name = "Ajay";
			
			System.out.println(Contractor.this.name);
			cbCount++;
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
