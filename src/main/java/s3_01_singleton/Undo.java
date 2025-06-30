package s3_01_singleton;

import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo instance;
    private List<String> commandHistory;

    private Undo() {
        System.out.println(" Undo instance created (only once!)");
        commandHistory = new ArrayList<>();
    }

    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    // Class methods Undo (add, delete, history) + check & delete

    public void addCommand(String command) {
        commandHistory.add(command);
    }

    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            String removedCommand = commandHistory.remove(commandHistory.size() - 1);
            System.out.println("Undone command: " + removedCommand);
        } else {
            System.out.println("No commands to undo.");
        }
    }

    public  void undoLastCommand() {
        if(!commandHistory.isEmpty()){
            commandHistory.remove(commandHistory.size() - 1);
        }else{
            System.out.println(" The list is empty");
        }
    }

}
