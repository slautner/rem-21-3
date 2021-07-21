package de.neuefische.rem_21_3.inheritance;

public class Rocket implements CanStart {

    @Override
    public void start() {
        System.out.println("Im launching");
    }
}
