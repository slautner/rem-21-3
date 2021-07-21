package de.neuefische.rem_21_3.interfaces;

// Animal is an abstraction and must not be initiated directly
public abstract class Animal {

    private final String name;

    // any Animal must have a name
    protected Animal(String name) {
        this.name = name;
    }

    public void move() {
        System.out.println(toString() + " and moving");
    }

    public String getName() {
        return name;
    }

    // must be implemented in subtypes of Animal
    abstract String getType();

    @Override
    public String toString() {
        return "I'm animal of type=" + getType() + " my name is " + getName();
    }
}
