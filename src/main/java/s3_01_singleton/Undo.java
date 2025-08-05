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
        checkCommandHistoryIsEmpty(); // cláusula de guarda
        return commandHistory.remove(commandHistory.size() - 1);
    }

    public List<String> seeListCommands() throws NoCommandsToUndoException {
        checkCommandHistoryIsEmpty();
        return commandHistory;
    }

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
