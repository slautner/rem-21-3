package de.neuefische.rem_21_3.interfaces;

public class Fish extends Animal implements LayEggs, Dive {

    protected Fish(String name) {
        super(name);
    }

    @Override
    String getType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void layEgg() {
        System.out.println("Laying 1000's of eggs");
    }

    @Override
    public int getDepthInMeters() {
        return 10;
    }
}
