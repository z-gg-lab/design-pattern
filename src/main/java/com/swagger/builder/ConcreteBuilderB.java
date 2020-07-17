package com.swagger.builder;

public class ConcreteBuilderB extends Builder{

    private Product product = new Product();

    @Override
    public void setPart() {
        product.setName("B");
    }

    @Override
    public Product buildProduct() {
        return product;
    }
}
