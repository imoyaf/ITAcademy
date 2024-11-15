package imf.app;

import imf.entity.Car;

public class App {
    public App(){}

    Car Ford1 = new Car("Focus", (short)1500);
    Car Ford2 = new Car("Cupra", (short)1200);

    public void run() {
        Ford1.accelerate();

        // From the class you cannot access a non-static method, there is a compiling error:
        // Car.accelerate();

        Car.brake();

        // The IDE gives a warning: Static member 'org.entity.Car.brake()' accessed via instance reference
        // It shouldn't be accessed through an instance but through the class
        Ford2.brake();
    }
}
