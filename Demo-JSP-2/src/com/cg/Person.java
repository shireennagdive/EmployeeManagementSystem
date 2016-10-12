package com.cg;


public class Person {
	// DATA MEMBERS
	private java.lang.String Name;
	private int age;
	private static int count;

	// MEMBER METHODS
	public Person() {
		Name = "Not There";
		age = 21;
		count=0;
	}
	public Person(String nsme,int age1){
		
		
	}

	public void setName(java.lang.String name) {
		Name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static void setCount(int count) {
		Person.count = count;
	}
	public java.lang.String getName() {
		return Name;
	}

	public int getAge() {
		return age;
	}
	public static int getCount(){
		
		return Person.count;
	}
}
