package imf.entity;

public class Car {
    private static final String BRAND = "Ford";
    private static String model;
    private final short power;

    public Car(String model, short power) {
        Car.model = model;
        this.power = power;
    }

    public static String getModel() {
        return model;
    }

    public static void setModel(String model) {
        Car.model = model;
    }

    public static String getBrand() {
        return BRAND;
    }

    public int getPower() {
        return this.power;
    }

    public static void brake() {
        System.out.println("The car is braking");
    }

    public void accelerate() {
        System.out.println("The car is accelerating");
    }

    @Override
    public String toString() {
        return "Car Brand = " + BRAND + "\n" + "Car Model = " + model + "\n" + "Car Power = " + this.power + "]";
    }
}
