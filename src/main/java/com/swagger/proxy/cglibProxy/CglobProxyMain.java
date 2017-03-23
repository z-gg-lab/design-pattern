package com.swagger.proxy.cglibProxy;

import com.swagger.proxy.jdkproxy.InterfaceImpl;

import net.sf.cglib.proxy.Enhancer;

public class CglobProxyMain {

	private static int a = 10;
	private static int b = 10;
	
	
	public static Object createCglibProxy(InterfaceImpl object){
		
		Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibProxyInterceptor(object));
        //这样和JDk的基本类似，都是针对接口实现动态代理
//        enhancer.setInterfaces(object.getClass().getInterfaces());
        //这样就可以直接对类实现动态代理
        enhancer.setSuperclass(object.getClass());
        
        return enhancer.create();
		
	}
	
	
	public static void main(String[] args) {


		InterfaceImpl impl = new InterfaceImpl();
		Object createCglibProxy = createCglibProxy(impl);
		
		((InterfaceImpl)createCglibProxy).add(a, b);
		((InterfaceImpl)createCglibProxy).sub(a, b);
	}
}
