package com.proxy;

import java.lang.reflect.Proxy;

public class TestProxy {

	public TestProxy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d=new Dog();
		String sing1=d.sing();
		System.out.println(sing1);
		System.out.println("---------------------------------------");
		Singable proxyInstance = (Singable) Proxy.newProxyInstance(TestProxy.class.getClassLoader(), new Class[]{Singable.class},new SingProxyHandler(d));
		String sing = proxyInstance.sing();
		System.out.println(sing);
		
	}

}
