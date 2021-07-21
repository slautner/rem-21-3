package de.neuefische.rem_21_3.inheritance;

/**
 * To change this template use File | Settings | File Templates.
 * <p>
 * Date: 21.07.21
 * Time: 10:25
 *
 * @author slautner
 */
public class FlyingCar extends Car {

    private int altitude = 0;

    @Override
    public void drive() {
        // overwrite drive from parent class Car, delegate to new method fly
        fly();
    }

    public void fly() {
        System.out.println("Im flying");
        setAltitude(100);
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
}
