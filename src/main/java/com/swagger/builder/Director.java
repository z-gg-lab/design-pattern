package com.swagger.builder;

/**
 * 导演：安排顺序，告诉Builder建造
 * 起到封装的作用，避免高层模块深入到建造者内部的实现类
 *
 * @author 003364
 */
public class Director {

    private Builder builderA = new ConcreteProductA();

    private Builder builderB = new ConcreteProductB();

    public Product getProductA() {
        builderA.setPart();
        return builderA.buildProduct();
    }

    public Product getProductB() {
        builderB.setPart();
        return builderB.buildProduct();
    }

    public static void main(String[] args) {
        Director director = new Director();
        System.out.println(director.getProductA().getName());
        System.out.println(director.getProductB().getName());
    }
}
