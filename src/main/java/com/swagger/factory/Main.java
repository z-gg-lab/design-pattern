package com.swagger.factory;

public class Main {

    public static void main(String[] args) {

        new ConcreteCreator().createProduct(ConcreteProduct1.class).method2();
        new ConcreteCreator().createProduct(ConcreteProduct2.class).method2();

        new ConcreteCreator1().createProduct().method2();
        new ConcreteCreator2().createProduct().method2();
    }
}
