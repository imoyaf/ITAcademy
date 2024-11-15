package imf.app;

import imf.domain.Smartphone;

public class App {
    public App() {}

    public void run() {
        Smartphone smartphone1 = new Smartphone("Nokia", "8210");

        smartphone1.alarm();
        smartphone1.takePhoto();
    }
}
