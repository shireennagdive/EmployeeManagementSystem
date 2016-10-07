package com.simulationdemo;

public abstract class Animal {
	// DATA MEMBERS

	public static void someUtility(){
		System.out.println("This is provided from Animal");
	}
	
	
	private String type;
	private String location;

	public void roam(){
		System.out.println("inside roam() of Animal");
	}
	
	
	public Animal(String type, String location) {
		this.type = type;
		this.location = location;
	}

	public String getLocation() {
		return location;
	}
	
	public String getType() {
		return type;
	}
	
	abstract public void sleep();/*{
//		METHOD BODY NOT ALLOWED
	}*/
	
	abstract public void eat();
	
}
