package com.simulationdemo;

abstract public class Feline extends Animal{

	public Feline(String type, String location) {
		super(type, location);
		// TODO Auto-generated constructor stub
	}

	final public void roam(){
		System.out.println("I roam alone....");
	}

	/*	public Feline() {
//		CHAINING CONSTRUCTOR USING 'super'
		super("NA","NA");
	}
*/
	


}
