package org.domain;

public abstract class Instruments {
    private String name;
    private float price;

    public Instruments(String name, float price) {
        this.name = name;
        this.price = price;
        System.out.println("Class loaded from the superclass constructor: " + this.getClass();
    }

    static {
        System.out.println("Class loaded from a static initialisation block of the superclass: " + this.getClass());
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString() {
        return "Instrument: " + this.name + ". Price: " + this.price;
    }

    public abstract void play();
}
