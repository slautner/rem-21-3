package de.neuefische.rem_21_3.inheritance;

public class RaceCar extends Car {

    @Override
    public void drive() {
        // overwrite drive from parent class Car
        System.out.println("Im racing on the track");
    }
}
