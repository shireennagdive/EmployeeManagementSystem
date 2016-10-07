package com.lists;

public class EmpKey implements Comparable  {

	public int id;
	public String suffix;
	public EmpKey(int id,String suffix){
		this.id=id;
		this.suffix=suffix;
	}
	@Override
	public int compareTo(Object o) {
		int diff=this.id-((EmpKey)o).id;
		return diff;
	}
	@Override
	public int hashCode() {
		int result=0;
		System.out.println("I am in hashcode");
		return (this.id)%3;
	}
	@Override
	public boolean equals(Object obj) {
		boolean flag=(this.id==((EmpKey)obj).id);
		return flag;
	}
	
	
	
}
