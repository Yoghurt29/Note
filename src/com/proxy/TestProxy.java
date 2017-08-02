package com.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.swing.plaf.synth.SynthStyle;

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
	/*public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Dog d=new Dog();
		System.out.println(d.sing());
		System.out.println("-----------------------------");
		Method method = d.getClass().getDeclaredMethod("sing", null);
		System.out.println(method.invoke(d, null));
		//System.err.println(method);
	}*/

}
