package com.swagger.proxy.cglibproxy;

import com.swagger.proxy.jdkproxy.InterfaceImpl;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhuTail
 */
public class CglibProxyInterceptor implements MethodInterceptor{

	
	private InterfaceImpl impl;
	
	public CglibProxyInterceptor(InterfaceImpl impl) {
		this.impl = impl;
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		
		String methodName = method.getName();
		System.out.println("方法名是："+methodName);
		Object result = method.invoke(impl,arg2);
		System.out.println("result:"+result);
		
		return result;
	}

}
