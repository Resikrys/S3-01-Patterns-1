package s3_01_command;

public class Boat implements Vehicle {
    private String model;

    public Boat(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println(model + " Boat: Engine started. Vroom vroom!");
    }

    @Override
    public void accelerate() {
        System.out.println(model + " Boat: Speeding up!");
    }

    @Override
    public void brake() {
        System.out.println(model + " Boat: Land in sight!");
    }
}
