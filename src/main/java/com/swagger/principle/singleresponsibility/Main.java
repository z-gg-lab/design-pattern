package com.swagger.principle.singleresponsibility;

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("飞机");
        vehicle.run("游轮");

        new RoadVehicle().run("汽车");
        new AirVehicle().run("飞机");
        new WaterVehicle().run("游轮");
    }
}
