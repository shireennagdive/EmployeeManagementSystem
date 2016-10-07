package com.simulationdemo;

public class Cat extends Feline implements Pet{
	@Override
	public void beFriendly() {
		System.out.println("I'm friendly");
		super.someUtility();
	}
	
	public static void someUtility(){
		System.out.println("This is provided from Cat");
	}
	
	@Override
	public void play() {
		System.out.println("I can play with you");
		System.out.println("MAX Pets: "+ MAX_ALLOWED);
	}
	
	public Cat(String type, String location) {
		super(type, location);
	}

	private int size;
	
	public int getSize() {
		return size;
	}
	
	@Override
	public void eat() {
		System.out.println("inside Cat's eat() version");
	}
	
	@Override
	public void sleep() {
		System.out.println("inside Cat's sleep() version");
	}
	
/*	@Override
	abstract public void roam(); {
		// TODO Auto-generated method stub
		super.roam();
	}
*/	
	
	
}
