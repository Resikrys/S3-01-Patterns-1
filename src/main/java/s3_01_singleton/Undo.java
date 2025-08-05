package s3_01_singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Undo {
    private static Undo instance;
    private List<String> commandHistory;

    private Undo() {
        commandHistory = new ArrayList<>();
    }

    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    public List<String> getCommandHistory() {
        return Collections.unmodifiableList(commandHistory);
    }

    public void checkCommandHistoryIsEmpty() throws NoCommandsToUndoException {
        if(commandHistory.isEmpty()) {
            throw new NoCommandsToUndoException("No commands in history.");
        }
    }

    public void addCommand(String command) {
        commandHistory.add(command);
    }

    public String undoLastCommand() throws NoCommandsToUndoException {
//        if (!commandHistory.isEmpty()) {
//            String removedCommand = commandHistory.remove(commandHistory.size() - 1);
//            System.out.println("Undone command: " + removedCommand);
//        } else {
//            System.out.println("No commands to undo.");
//        }
        checkCommandHistoryIsEmpty(); // cláusula de guarda
        return commandHistory.remove(commandHistory.size() - 1);
    }

//    public void seeListCommands() {
//        if (commandHistory.isEmpty()) {
//            System.out.println("No commands in history.");
//        } else {
//            System.out.println("Command history:");
//            for (int i = 0; i < commandHistory.size(); i++) {
//                System.out.println((i + 1) + ": " + commandHistory.get(i));
//            }
//            System.out.println("-----------------------------\n");
//        }
//    }
    public List<String> seeListCommands() throws NoCommandsToUndoException {
        checkCommandHistoryIsEmpty();
        return commandHistory;
    }

//    public void checkAndDelete(String commandToDelete) {
//        if (commandHistory.remove(commandToDelete)) {
//            System.out.println("Command erased: '" + commandToDelete + "'");
//        } else {
//            System.out.println("Command '" + commandToDelete + "' not found in history.");
//        }
//    }
    public boolean checkAndDelete(String commandToDelete) {
        return commandHistory.remove(commandToDelete);
    }

    public void clearHistory() {
        commandHistory.clear();
    }

    @Override
    public String toString() {
        return "Undo{" +
                "commandHistory=" + commandHistory +
                '}';
    }

}
