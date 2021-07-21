package de.neuefische.rem_21_3.inheritance;

import org.junit.jupiter.api.Test;

class RaceCarTest {

    @Test
    public void testDrivingRaceCar() {
        Car raceCar = new RaceCar();
        raceCar.drive();
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
