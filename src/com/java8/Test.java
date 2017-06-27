package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Test {
	public Test() {
		
	}
	public static void main(String[] args) {
		List<String> list=new ArrayList();
		list.add("hello");
		list.add("java");
		list.add("world");
		list.add("!");

		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
	}
}
