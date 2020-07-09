package com.swagger.builder;

public class ConcreteProductB extends Builder{

    private Product product = new ProductA();

    @Override
    public void setPart() {
        product.setName("B");
    }

    @Override
    public Product buildProduct() {
        return product;
    }
}
