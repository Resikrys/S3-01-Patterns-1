package s3_01_command.vehicle;

// Car.java
public class Car implements Vehicle {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public String start() {
        return model + " Car: Engine started. Vroom vroom!";
    }

    @Override
    public String accelerate() {
        return model + " Car: Speeding up!";
    }

    @Override
    public String brake() {
        return model + " Car: Braking now. Squeeeal!";
    }
}
