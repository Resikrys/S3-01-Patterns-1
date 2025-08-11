package s3_01_command.command;

import s3_01_command.vehicle.Vehicle;

public class StartCommand implements Command {
    private Vehicle vehicle;

    public StartCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.start();
    }
}
