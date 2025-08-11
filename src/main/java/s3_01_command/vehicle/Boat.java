package s3_01_command.vehicle;

public class Boat implements Vehicle {
    private String model;

    public Boat(String model) {
        this.model = model;
    }

    @Override
    public String start() {
        return model + " Boat: Engine started. Vroom vroom!";
    }

    @Override
    public String accelerate() {
        return model + " Boat: Speeding up!";
    }

    @Override
    public String brake() {
        return model + " Boat: Land in sight!";
    }
}
