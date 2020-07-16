package com.swagger.factory.abs;

public class RedFactory implements DrawFactory{

    @Override
    public Circle getCircle() {
        return new RedCircle();
    }

    @Override
    public Rectangle getRectangle() {
        return new RedRectangle();
    }
}
