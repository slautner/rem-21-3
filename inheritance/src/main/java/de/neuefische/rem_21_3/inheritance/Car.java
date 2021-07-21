package de.neuefische.rem_21_3.inheritance;

public class Car implements CanStart {

    public void drive() {
        // default behaviour for any kind of cars
        System.out.println("Im cruising on the street");
    }

    @Override
    public void start() {
        System.out.println("Engine started");
    }
}
