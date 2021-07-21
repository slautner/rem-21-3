package de.neuefische.rem_21_3.interfaces;

import org.junit.jupiter.api.Test;


class AnimalTest {

    @Test
    public void testCreateAnimal() {
        Bird bird = new Bird("Bird");
        bird.move();
        bird.fly();

        Cat cat = new Cat("Cat");
        cat.move();

        Fish fish = new Fish("Fish");
        fish.move();

        SeaGull seaGull = new SeaGull("SeaGull");
        seaGull.move();
        seaGull.fly();

        Animal[] animals = {bird, cat, fish, seaGull};
        animals[0].getType();
        animals[0].getName();
        animals[0].move();
    }

    @Test
    public void testBirdLayEggs() {
        Bird bird = new Bird("Bird");
        bird.layEgg();
        bird.move();

        Fish fish = new Fish("Fish");
        fish.layEgg();
        fish.move();

        SeaGull seaGull = new SeaGull("Seagull");
        seaGull.dive();
        seaGull.layEgg();
        seaGull.move();
        seaGull.fly();

        Bird seaGullBird = seaGull;
        //seaGullBird.dive();  // this seaGullBird is of type Bird and Bird does not implement the dive() method
        seaGullBird.layEgg();
        seaGullBird.fly();

        // collect any animal
        Animal[] animals = {bird, fish};
        animals[0].getType();
        animals[0].getName();
        animals[0].move();

        // collect anything who can "lay some eggs"
        LayEggs[] layEggs = {bird, fish};
        layEggs[0].layEgg();

        // collect anything who can "dive"
        Dive[] dives = {fish, seaGull};
        dives[0].dive();
        dives[0].getDepthInMeters();
    }
}
