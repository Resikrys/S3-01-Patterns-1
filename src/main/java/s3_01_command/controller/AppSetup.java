package s3_01_command.controller;

import s3_01_command.command.AccelerateCommand;
import s3_01_command.command.BrakeCommand;
import s3_01_command.command.Command;
import s3_01_command.command.StartCommand;
import s3_01_command.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class AppSetup {
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
