package org.domain;

public class WindInstruments extends Instruments {
    public WindInstruments(String name, float price) {
        super(name, price);
        System.out.println("Class loaded from the constructor of subclass: " + this.getClass());
    }

    static {
        System.out.println
                ("Class loaded from a static initialisation block of the subclass: "
                        + WindInstruments.class);
    }

    @Override
    public void play() {
        System.out.println("A wind instrument is being played");
    }
}
