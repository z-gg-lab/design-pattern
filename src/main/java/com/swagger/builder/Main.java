package com.swagger.builder;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Director(new ConcreteBuilderA()).getProduct().getName());
        System.out.println(new Director(new ConcreteBuilderB()).getProduct().getName());
    }
}
