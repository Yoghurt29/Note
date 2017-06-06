package com.yo;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Test01 {

	public Test01() {
		// TODO Auto-generated constructor stub
	}
	
	public int fun(){
		try {
			int a=5/0;
			return a;
		} catch (Exception e) {
			// TODO: handle exception
			return 50;
		}
	}
	public static void main(String[] args) throws IOException {
		System.out.println(new Test01().fun());
		int a=0b010;
		int b=0xac;
		int c=077;
		System.out.println(c);
		System.out.println(a);
	}
}
