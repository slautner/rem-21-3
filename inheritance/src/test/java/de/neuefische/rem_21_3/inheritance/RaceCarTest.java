package de.neuefische.rem_21_3.inheritance;

import org.junit.jupiter.api.Test;

public class RaceCarTest {

    @Test
    public void testDrivingRaceCar() {
        Car raceCar = new RaceCar();
        raceCar.drive();
        raceCar.start();
        // downcast
        RaceCar castedRaceCar = (RaceCar) raceCar;
        castedRaceCar.slowDown();

        // ups - ClassCastException!
        // FlyingCar castedFlyingCar = (FlyingCar) raceCar;

        RaceCar realRaceCar = new RaceCar();
        realRaceCar.drive();
        realRaceCar.start();
        realRaceCar.slowDown();

        CanStart canStart = new RaceCar();
        canStart.start();
        // downcast
        RaceCar castedCanStart = (RaceCar) canStart;
        castedCanStart.slowDown();

        CanStart rocketCanStart = new Rocket();
        rocketCanStart.start();

        // ups - ClassCastException!
        // RaceCar cannotCastRaceCar = (RaceCar) rocketCanStart;
    }

    @Test
    public void testDrivingFamilyVan() {
        Car familyVan = new FamilyVan();
        familyVan.drive();
    }

    @Test
    public void testDrivingFlyingCar() {
        // only the methods of Car are available for variable "flyingCar" of type "Car"
        // because of init a type "Car" with "FlyingCar" it is castable "upwards" to "FlyingCar"
        Car flyingCar = new FlyingCar();
        flyingCar.drive();

        // upcasting
        FlyingCar castedFlyingCar = (FlyingCar) flyingCar;

        // all methods of FlyingCar available for variable "realFlyingCar" of type "FlyingCar"
        FlyingCar realFlyingCar = new FlyingCar();
        realFlyingCar.drive();
        realFlyingCar.fly();
        realFlyingCar.getAltitude();


        // downcasting - on any time a "child" object can be assigned to its parent type
        Car car = realFlyingCar;

        // downcasting
        Object carObj = new Car();
        Object flyObj = new FlyingCar();
    }
}
