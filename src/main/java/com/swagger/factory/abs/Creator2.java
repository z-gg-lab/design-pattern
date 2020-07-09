package com.swagger.factory.abs;


public class Creator2 extends AbstractCreator {

    /**
     * 生产等级为2的A产品
     */
    @Override
    public AbstractProductA createProductA() {
        System.out.println("生产等级为2的A产品");
        return new ProductA2();
    }
    /**
     * 生产等级为2的B产品
     */
    @Override
    public AbstractProductB createProductB() {
        System.out.println("生产等级为2的B产品");
        return new ProductB2();
    }
}
