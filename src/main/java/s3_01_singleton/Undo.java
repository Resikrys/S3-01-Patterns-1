package s3_01_singleton;

import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo instance;
    private List<String> commandHistory;

    private Undo() {
        System.out.println("Undo instance created (only once!)");
        commandHistory = new ArrayList<>();
    }

    public static Undo getInstance() {
        //In a production environment, you would consider thread-safety here (like the example)
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
//        this.value = value;
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    // Class methods Undo (add command, delete last, see history) + check & delete, clear history

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

    public void seeListCommands() {
        if (commandHistory.isEmpty()) {
            System.out.println("No commands in history.");
        } else {
            System.out.println("Command history:");
            for (int i = 0; i < commandHistory.size(); i++) {
                System.out.println((i + 1) + ": " + commandHistory.get(i));
            }
            System.out.println("-----------------------------\n");
        }
    }

    public void checkAndDelete(String commandToDelete) {
        if (commandHistory.remove(commandToDelete)) {
            System.out.println("Command erased: '" + commandToDelete + "'");
        } else {
            System.out.println("Command '" + commandToDelete + "' not found in history.");
        }
    }

    public void clearHistory() {
        commandHistory.clear();
        System.out.println("Command history cleaned.");
    }

}
