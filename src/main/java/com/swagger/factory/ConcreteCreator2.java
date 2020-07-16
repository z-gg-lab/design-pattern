package com.swagger.factory;

import lombok.extern.java.Log;

/**
 * @author 003364
 */
@Log
public class ConcreteCreator2 implements Creator1 {

    @Override
    public Product createProduct() {
        System.out.println("ConcreteCreator2 创建了 ConcreteProduct2");
        return new ConcreteProduct2();
    }
}
