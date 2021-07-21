package de.neuefische.rem_21_3.interfaces;

public interface Dive {

    default void dive() {
        // the default implementation uses an other method to "complete" their work
        System.out.println("I'm diving " + getDepthInMeters() + " meters into the see");
    }

    int getDepthInMeters();
}
