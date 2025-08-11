package s3_01_command.controller;

import s3_01_command.command.AccelerateCommand;
import s3_01_command.command.BrakeCommand;
import s3_01_command.command.Command;
import s3_01_command.command.StartCommand;
import s3_01_command.vehicle.*;

import java.util.HashMap;
import java.util.Map;

public class AppSetup {
    /**
     * Crea y devuelve una nueva instancia de Car.
     * @param model El modelo del coche.
     * @return Un objeto Car.
     */
    public static Car createCar(String model) {
        return new Car(model);
    }

    public static Bike createBike(String model) {
        return new Bike(model);
    }

    public static Plane createPlane(String model) { return new Plane(model); }
    public static Boat createBoat(String model) { return new Boat(model); }

    /**
     * Crea y devuelve un mapa de comandos para un vehículo dado.
     * @param vehicle El vehículo para el cual se crearán los comandos.
     * @return Un Map<String, Command> con los comandos "start", "accelerate" y "brake".
     */
    public static Map<String, Command> createVehicleCommands(Vehicle vehicle) {
        Map<String, Command> commands = new HashMap<>();
        commands.put("start", new StartCommand(vehicle));
        commands.put("accelerate", new AccelerateCommand(vehicle));
        commands.put("brake", new BrakeCommand(vehicle));
        return commands;
    }
}
