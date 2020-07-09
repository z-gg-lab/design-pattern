package com.swagger.builder;

/**
 * 抽象建造者
 * @author 003364
 */
public abstract class Builder {

    /**
     * 设置产品属性，获得不同的产品
     */
    public abstract void setPart();

    /**
     * 建造产品
     * @return product
     */
    public abstract Product buildProduct();
}
