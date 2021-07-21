package de.neuefische.rem_21_3.inheritance;

public class RaceCar extends Car {

    @Override
    public void drive() {
        // overwrite drive from parent class Car
        System.out.println("Im racing on the track");
    }

    public void slowDown() {
        System.out.println("He I'm a race car, I will go fast!");
    }
}
