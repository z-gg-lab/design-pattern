package com.swagger.builder;

/**
 * 具体的建造者
 *
 * @author 003364
 */
public class ConcreteBuilderA extends Builder{

    private Product product = new Product();

    @Override
    public void setPart() {
        product.setName("A");
    }

    @Override
    public Product buildProduct() {
        return product;
    }
}
