package com.swagger.factory.abs;


public class Creator1 extends AbstractCreator {

    /**
     * 生产等级为1的A产品
     */
    @Override
    public AbstractProductA createProductA() {
        System.out.println("生产等级为1的A产品");
        return new ProductA1();
    }
    /**
     * 生产等级为1的B产品
     */
    @Override
    public AbstractProductB createProductB() {
        System.out.println("生产等级为1的B产品");
        return new ProductB1();
    }
}
