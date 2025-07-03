package s3_01_command;

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
