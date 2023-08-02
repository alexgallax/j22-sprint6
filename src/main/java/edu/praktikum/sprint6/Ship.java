package edu.praktikum.sprint6;

public class Ship {

    private final Sail sail = new Sail(2);

    public int getMaxSpeed() {
        return sail.getMaxPower() * 4;
    }
}
