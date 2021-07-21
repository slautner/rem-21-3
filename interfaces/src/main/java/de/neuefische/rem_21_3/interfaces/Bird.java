package de.neuefische.rem_21_3.interfaces;

public class Bird extends Animal implements LayEggs {

    public Bird(String name) {
        super(name);
    }

    @Override
    String getType() {
        return this.getClass().getSimpleName();
    }

    public void fly() {
        System.out.println("I'm flying");
    }
}
