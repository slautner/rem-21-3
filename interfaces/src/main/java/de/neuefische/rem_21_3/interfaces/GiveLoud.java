package de.neuefische.rem_21_3.interfaces;

public interface GiveLoud {

    default void giveLoud() {
        System.out.println("I'm giving a loud");
    }
}
