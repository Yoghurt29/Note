package com.proxy;

public class Dog implements Singable{

	public Dog() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sing() {
		System.out.println("汪汪汪");
		return "狗";
	}

}
