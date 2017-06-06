package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SingProxyHandler implements InvocationHandler {
	//被代理的真實對象,某個動物
	private Object proxiedObj;
	public SingProxyHandler() {
		// TODO Auto-generated constructor stub
	}
	public SingProxyHandler(Object o) {
		// TODO Auto-generated constructor stub
		this.proxiedObj=o;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("我是貓,喵喵喵!");
		//Object o=method.invoke(proxiedObj, args);
		return "貓";
	}

}
