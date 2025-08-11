package s3_01_command.vehicle;

public class Bike implements Vehicle {
    private String color;

    public Bike(String color) {
        this.color = color;
    }

    @Override
    public String start() {
        return color + " Bike: Ready, steady, go!!";
    }

    @Override
    public String accelerate() {
        return color + " Bike: Catch me if you can!";
    }

    @Override
    public String brake() {
        return color + " Bike: Braking now. Squeeeal!";
    }
}
