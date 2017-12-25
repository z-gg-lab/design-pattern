package com.swagger.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author zhutail
 */
public class JdkProxyMain {
	
	private static int a = 10;
	private static int b = 10;

	public static Object createJDKProxy(InterfaceImpl impl){
		
		Object newProxyInstance = Proxy.newProxyInstance(impl.getClass().getClassLoader(), 
				impl.getClass().getInterfaces(), new JdkProxyHandler(impl));
		return newProxyInstance;
	}
	
	public static void main(String[] args) {
		
		InterfaceImpl impl = new InterfaceImpl();
		Object createImpl = createJDKProxy(impl);
		
		((AddInterface)createImpl).add(a, b);
		((SubInterface)createImpl).sub(a, b);
	}
	
}
