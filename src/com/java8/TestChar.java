package com.java8;

import java.util.ArrayList;
import java.util.function.Consumer;

public class TestChar {

	public TestChar() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arrayTest();
		/*char ch=97;
		char A=65;
		String s=""+ch;
		System.out.println(ch);
		System.out.println(s);
		
		int aAsic='a';
		for (int i = 0; i < 52; i++) {
			
			System.out.println((char)(aAsic++));
		}*/
	}
	public static void arrayTest(){
		ArrayList l=new ArrayList<String>();
		l.add("hello");
		l.forEach(new Consumer() {
			@Override
			public void accept(Object l) {
				System.out.println("what");
			}
		});
	}

}
