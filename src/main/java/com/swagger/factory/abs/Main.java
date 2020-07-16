package com.swagger.factory.abs;

public class Main {

    public static void main(String[] args) {
        DrawFactory redFactory = new RedFactory();
        redFactory.getCircle().draw();
        redFactory.getRectangle().draw();

        DrawFactory blueFactory = new BlueFactory();
        blueFactory.getCircle().draw();
        blueFactory.getRectangle().draw();
    }
}
