package org.domain;

public class PercussionInstruments extends Instruments {
    public PercussionInstruments(String name, float price) {
        super(name, price);
        System.out.println("Class loaded from the constructor of subclass: " + this.getClass());
    }

    static {
        System.out.println
                ("Class loaded from a static initialisation block of the subclass: "
                        + PercussionInstruments.class);
    }

    @Override
    public void play() {
        System.out.println("A percussion instrument is being played");
    }
}
