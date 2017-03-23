package com.swagger.proxy.jdkproxy;

import java.lang.reflect.Proxy;

public class JDKProxyMain {
	
	private static int a = 10;
	private static int b = 10;

	// 创建代理对象
	public static Object createJDKProxy(InterfaceImpl impl){
		
		Object newProxyInstance = Proxy.newProxyInstance(impl.getClass().getClassLoader(), 
				impl.getClass().getInterfaces(), new JDKProxHandler(impl));
		return newProxyInstance;
	}
	
	public static void main(String[] args) {
		
		InterfaceImpl impl = new InterfaceImpl();
		Object createimpl = createJDKProxy(impl);
		
		((AddInterface)createimpl).add(a, b);
		((SubInterface)createimpl).sub(a, b);
	}
	
}
