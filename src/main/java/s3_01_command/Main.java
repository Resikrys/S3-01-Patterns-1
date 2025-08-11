package s3_01_command;

import s3_01_command.command.AccelerateCommand;
import s3_01_command.command.BrakeCommand;
import s3_01_command.command.Command;
import s3_01_command.command.StartCommand;
import s3_01_command.controller.AppSetup;
import s3_01_command.controller.VehicleController;
import s3_01_command.vehicle.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Citroën shark");
        Vehicle bike = new Bike("Yellow");
        Vehicle plane = new Plane("Boeing 747");
        Vehicle boat = new Boat("Pirate brig");

        Map<String, Command> carCommands = AppSetup.createVehicleCommands(car);
        Map<String, Command> bikeCommands = AppSetup.createVehicleCommands(bike);
        Map<String, Command> planeCommands = AppSetup.createVehicleCommands(plane);
        Map<String, Command> boatCommands = AppSetup.createVehicleCommands(boat);

        // 2. Fase de Ejecución: Utilizar el controlador para ejecutar los comandos.
        VehicleController controller = new VehicleController();

        System.out.println("\n--- Car Actions ---");
        controller.setCommand(carCommands.get("start"));
        controller.execute();

        controller.setCommand(carCommands.get("accelerate"));
        controller.execute();

        Command accelerateCar = new AccelerateCommand(car);
        controller.setCommand(accelerateCar);
        controller.execute();

        System.out.println(System.lineSeparator() + "--- Bike Actions ---");
        controller.setCommand(bikeCommands.get("start"));
        controller.execute();

        controller.setCommand(bikeCommands.get("brake"));
        controller.execute();

//        System.out.println("\n--- End of Actions ---");
//
//        System.out.println("\n--- Testing null command ---");
//        controller.setCommand(null);
//        controller.execute();

    }
}
