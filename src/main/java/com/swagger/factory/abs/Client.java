package com.swagger.factory.abs;


public class Client {

    public static void main(String[] args) {
        AbstractCreator creator1 = new Creator1();
        AbstractCreator creator2 = new Creator2();

        AbstractProductA productA1 = creator1.createProductA();
        productA1.personalMethod();
        AbstractProductA productA2 = creator2.createProductA();
        productA2.personalMethod();

        AbstractProductB productB1 = creator1.createProductB();
        productB1.personalMethod();
        AbstractProductB productB2 = creator2.createProductB();
        productB2.personalMethod();
    }
}
