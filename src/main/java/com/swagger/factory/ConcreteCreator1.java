package com.swagger.factory;

import lombok.extern.java.Log;

/**
 * @author 003364
 */
@Log
public class ConcreteCreator1 implements Creator1 {

    @Override
    public Product createProduct() {
        System.out.println("ConcreteCreator1 创建了 ConcreteProduct1");
        return new ConcreteProduct1();
    }
}
