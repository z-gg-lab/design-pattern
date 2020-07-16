package com.swagger.builder;

/**
 * 导演：安排顺序，告诉Builder建造
 * 起到封装的作用，避免高层模块深入到建造者内部的实现类
 *
 * @author 003364
 */
public class Director {

    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public Product getProduct() {
        builder.setPart();
        return builder.buildProduct();
    }
}
