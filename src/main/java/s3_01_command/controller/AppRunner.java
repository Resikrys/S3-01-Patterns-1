package s3_01_command.controller;

import s3_01_command.command.Command;
import s3_01_command.vehicle.Vehicle;

import java.util.Map;

public class AppRunner {
    public static void runDemo() {
        // Fase de Configuración
        Vehicle car = AppSetup.createCar("Citroën shark");
        Vehicle bike = AppSetup.createBike("Yellow");
        Vehicle plane = AppSetup.createPlane("Boeing 747");
        Vehicle boat = AppSetup.createBoat("Pirate brig");

        Map<String, Command> carCommands = AppSetup.createVehicleCommands(car);
        Map<String, Command> bikeCommands = AppSetup.createVehicleCommands(bike);
        Map<String, Command> planeCommands = AppSetup.createVehicleCommands(plane);
        Map<String, Command> boatCommands = AppSetup.createVehicleCommands(boat);

        // Fase de Ejecución
        VehicleController controller = new VehicleController();

        System.out.println("\n--- Car Actions ---");
        controller.setCommand(carCommands.get("start"));
        controller.execute();

        controller.setCommand(carCommands.get("accelerate"));
        controller.execute();

        System.out.println(System.lineSeparator() + "--- Bike Actions ---");
        controller.setCommand(bikeCommands.get("start"));
        controller.execute();

        controller.setCommand(bikeCommands.get("brake"));
        controller.execute();
    }
}
