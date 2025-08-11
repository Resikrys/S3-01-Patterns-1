package s3_01_command.controller;

import s3_01_command.command.Command;

public class VehicleController {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute() {
        if(command != null) {
            command.execute();
        } else {
            System.out.println("No command received.");
        }
    }
}
