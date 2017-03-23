package com.swagger.proxy.jdkproxy;

public class InterfaceImpl implements AddInterface, SubInterface {

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

}
