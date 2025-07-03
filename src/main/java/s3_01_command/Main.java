package s3_01_command;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Citroën shark");
        Bike bike = new Bike("Yellow");
        Plane plane = new Plane("Boeing 747");
        Boat boat = new Boat("Pirate brig");

        VehicleController controller = new VehicleController();

        System.out.println("\n--- Car Actions ---");
        Command startCar = new StartCommand(car);
        controller.setCommand(startCar);
        controller.execute();

        Command brakeCar = new BrakeCommand(car);
        controller.setCommand(brakeCar);
        controller.execute();

        Command accelerateCar = new AccelerateCommand(car);
        controller.setCommand(accelerateCar);
        controller.execute();

//        System.out.println("\n--- Bike Actions ---");
        System.out.println(System.lineSeparator() + "--- Bike Actions ---");
        Command startBike = new StartCommand(bike);
        controller.setCommand(startBike);
        controller.execute();

        System.out.println("\n--- Plane Actions ---");
        Command startPlane = new StartCommand(plane);
        controller.setCommand(startPlane);
        controller.execute();

        Command acceleratePlane = new AccelerateCommand(plane);
        controller.setCommand(acceleratePlane);
        controller.execute();

        System.out.println("\n--- Boat Actions ---");
        Command startBoat = new StartCommand(boat);
        controller.setCommand(startBoat);
        controller.execute();

        Command brakeBoat = new BrakeCommand(boat);
        controller.setCommand(brakeBoat);
        controller.execute();

        System.out.println("\n--- End of Actions ---");

        System.out.println("\n--- Testing null command ---");
        controller.setCommand(null);
        controller.execute();

    }
}
