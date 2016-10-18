package com.shireen;

import javax.xml.bind.annotation.XmlRootElement;

//package main.java.l2;
@XmlRootElement
public class Person {
private int age;
private String Name;
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}

}
