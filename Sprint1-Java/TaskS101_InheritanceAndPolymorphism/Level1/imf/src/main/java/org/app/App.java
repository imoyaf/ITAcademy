package org.app;

import org.domain.PercussionInstruments;
import org.domain.StringInstruments;
import org.domain.WindInstruments;

public class App {
    public App() {}

    WindInstruments sax = new WindInstruments("Saxophone", 1224.99F);
    StringInstruments guitar = new StringInstruments("Guitar", 699.99F);
    PercussionInstruments drum = new PercussionInstruments("Drum", 449.99F);

    public void run() {
        sax.play();
        guitar.play();
        drum.play();
    }
}
