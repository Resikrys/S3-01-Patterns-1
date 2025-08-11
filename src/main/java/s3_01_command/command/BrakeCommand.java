package s3_01_command.command;

import s3_01_command.vehicle.Vehicle;

public class BrakeCommand implements Command {
    private Vehicle vehicle;

    public BrakeCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.brake();
    }
}
