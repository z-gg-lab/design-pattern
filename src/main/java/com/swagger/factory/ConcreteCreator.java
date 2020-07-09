package com.swagger.factory;

import lombok.extern.java.Log;

/**
 * @author 003364
 */
@Log
public class ConcreteCreator implements Creator {
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = c.newInstance();
        } catch (Exception e) {
            log.warning("xxx");
        }
        return (T) product;
    }

    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        ConcreteProduct1 product1 = creator.createProduct(ConcreteProduct1.class);
        ConcreteProduct2 product2 = creator.createProduct(ConcreteProduct2.class);
        product1.method2();
        product2.method2();
    }
}
