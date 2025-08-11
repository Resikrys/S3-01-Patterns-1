package s3_01_command.vehicle;

public class Plane implements Vehicle {
    private String model;

    public Plane(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println(model + " Plane: To infinity and beyond!");
    }

    @Override
    public void accelerate() {
        System.out.println(model + " Plane: Watch out, little birds!");
    }

    @Override
    public void brake() {
        System.out.println(model + " Plane: Time to slow down!");
    }
}
