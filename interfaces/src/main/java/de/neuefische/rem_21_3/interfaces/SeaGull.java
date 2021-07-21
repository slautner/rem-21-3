package de.neuefische.rem_21_3.interfaces;

public class SeaGull extends Bird implements Dive {

    public SeaGull(String name) {
        super(name);
    }

    @Override
    public int getDepthInMeters() {
        return 3;
    }
}
