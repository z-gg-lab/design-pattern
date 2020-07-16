package com.swagger.factory.abs;

public class BlueFactory implements DrawFactory{

    @Override
    public Circle getCircle() {
        return new BlueCircle();
    }

    @Override
    public Rectangle getRectangle() {
        return new BlueRectangle();
    }
}
