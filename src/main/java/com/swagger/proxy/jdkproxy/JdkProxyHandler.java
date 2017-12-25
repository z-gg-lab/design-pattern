package com.swagger.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理
 * 		InvocationHandler 切面
 * @author Administrator
 *
 */
public class JdkProxyHandler implements InvocationHandler {

	private InterfaceImpl impl;
	
	public JdkProxyHandler(InterfaceImpl impl) {
		this.impl = impl;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		String methodName = method.getName();
		System.out.println("方法名："+methodName);
		Object object = method.invoke(impl, args);
		System.out.println("结果为："+object);
		return object;
	}

}
