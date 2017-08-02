package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SingProxyHandler implements InvocationHandler {
	//被代理的真實對象,某個動物
	private Object proxiedObj;
	public SingProxyHandler() {
	}
	public SingProxyHandler(Object o) {
		this.proxiedObj=o;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("我准备好了");
			//Object o=method.invoke(proxiedObj, args);
		System.out.println("我结束了");
		return "貓";
	}
	
}
