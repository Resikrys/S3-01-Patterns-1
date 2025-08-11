package s3_01_command.vehicle;

public class Plane implements Vehicle {
    private String model;

    public Plane(String model) {
        this.model = model;
    }

    @Override
    public String start() {
        return model + " Plane: To infinity and beyond!";
    }

    @Override
    public String accelerate() {
        return model + " Plane: Watch out, little birds!";
    }

    @Override
    public String brake() {
        return model + " Plane: Time to slow down!";
    }
}
