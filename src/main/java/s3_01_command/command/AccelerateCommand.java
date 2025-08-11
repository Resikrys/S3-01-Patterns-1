package s3_01_command.command;

import s3_01_command.vehicle.Vehicle;

public class AccelerateCommand implements Command {
    private Vehicle vehicle;

    public AccelerateCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.accelerate();
    }
}
