package com.swagger.factory.abs;

/**
 * 有N个产品族，在抽象工厂类中就应该有N个创建方法。
 *
 *
 * @author 003364
 */

public abstract class AbstractCreator {

    /**
     * 创建产品A家族
     * @return
     */
    public abstract AbstractProductA createProductA();

    /**
     * 创建产品B家族
     * @return
     */
    public abstract AbstractProductB createProductB();

}
