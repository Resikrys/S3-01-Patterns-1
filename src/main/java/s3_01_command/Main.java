package s3_01_command;

import s3_01_command.command.AccelerateCommand;
import s3_01_command.command.BrakeCommand;
import s3_01_command.command.Command;
import s3_01_command.command.StartCommand;
import s3_01_command.controller.VehicleController;
import s3_01_command.vehicle.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. Fase de Configuración (Setup): Crear vehículos y comandos.
        Vehicle car = new Car("Citroën shark");
        Vehicle bike = new Bike("Yellow");
        Vehicle plane = new Plane("Boeing 747");
        Vehicle boat = new Boat("Pirate brig");

        // Creamos una lista de comandos para cada vehículo
        Map<String, Command> carCommands = new HashMap<>();
        carCommands.put("start", new StartCommand(car));
        carCommands.put("accelerate", new AccelerateCommand(car));
        carCommands.put("brake", new BrakeCommand(car));

        Map<String, Command> bikeCommands = new HashMap<>();
        bikeCommands.put("start", new StartCommand(bike));
        bikeCommands.put("accelerate", new AccelerateCommand(bike));
        bikeCommands.put("brake", new BrakeCommand(bike));

        Map<String, Command> planeCommands = new HashMap<>();
        planeCommands.put("start", new StartCommand(plane));
        planeCommands.put("accelerate", new AccelerateCommand(plane));
        planeCommands.put("brake", new BrakeCommand(plane));

        Map<String, Command> boatCommands = new HashMap<>();
        boatCommands.put("start", new StartCommand(boat));
        boatCommands.put("accelerate", new AccelerateCommand(boat));
        boatCommands.put("brake", new BrakeCommand(boat));

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
