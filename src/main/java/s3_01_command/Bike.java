package s3_01_command;

public class Bike implements Vehicle {
    private String color;

    public Bike(String color) {
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println(color + " Bike: Ready, steady, go!!");
    }

    @Override
    public void accelerate() {
        System.out.println(color + " Bike: Catch me if you can!");
    }

    @Override
    public void brake() {
        System.out.println(color + " Bike: Braking now. Squeeeal!");
    }
}
