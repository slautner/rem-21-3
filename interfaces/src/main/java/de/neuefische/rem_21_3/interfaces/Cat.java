package de.neuefische.rem_21_3.interfaces;

public class Cat extends Animal {

    protected Cat(String name) {
        super(name);
    }

    @Override
    String getType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void move() {
        System.out.println(toString() + " im sneaking");
    }
}
