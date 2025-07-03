package s3_01_command;

// Car.java
public class Car implements Vehicle {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println(model + " Car: Engine started. Vroom vroom!");
    }

    @Override
    public void accelerate() {
        System.out.println(model + " Car: Speeding up!");
    }

    @Override
    public void brake() {
        System.out.println(model + " Car: Braking now. Squeeeal!");
    }
}
