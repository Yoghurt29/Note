package com.day20170624;

public class Student {
	private String name;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(String name) {
		super();
		this.name = name;
	}
}
