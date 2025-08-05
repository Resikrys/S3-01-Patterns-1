package s3_01_singleton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class Manager {
    private Undo undoManager;
    private Scanner scanner;
    private final Map<String, Consumer<String>> commandHandlers;

    public Manager() {
        this.undoManager = Undo.getInstance();
        this.scanner = new Scanner(System.in);
        this.commandHandlers = new HashMap<>();
        initializeCommands();
        System.out.println("Command Console Started. Type 'help' to see the available commands.");
    }

    private void initializeCommands() {
        commandHandlers.put("add", this::handleAdd);
        commandHandlers.put("undo", this::handleUndo);
        commandHandlers.put("delete", this::handleDelete);
        commandHandlers.put("history", this::handleHistory);
        commandHandlers.put("clear", this::handleClear);
        commandHandlers.put("help", this::handleHelp);
    }

    public void startProgram() {
        String input;
        while (true) {
            System.out.print("Enter a command > ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Bye bye, see you soon!");
                break;
            }

            try {
                commandHandler(input);
            } catch (InvalidCommandException | NoCommandsToUndoException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("An unexpected error has occurred: " + e.getMessage());
            }
            System.out.println();
        }
        scanner.close();
    }

    private void commandHandler(String command) {
        String trimmedCommand = command.trim();
        if (trimmedCommand.isEmpty()) {
            return;
        }

        String[] parts = trimmedCommand.split(" ", 2);
        String action = parts[0].toLowerCase();
        String argument = (parts.length > 1) ? parts[1].trim() : "";

        Consumer<String> handler = commandHandlers.get(action);
        if (handler != null) {
            handler.accept(argument);
        } else {
            throw new InvalidCommandException("Invalid command: '" + action + "'. Type 'help' to see all available commands.");
        }
    }

    private void checkArgumentIsPresent(String argument, String commandName) {
        if (argument.isEmpty()) {
            throw new InvalidCommandException("Command '" + commandName + "' requires a text. Use: " + commandName + " <text>");
        }
    }

    private void checkArgumentIsNotPresent(String argument, String commandName) {
        if (!argument.isEmpty()) {
            throw new InvalidCommandException("Command '" + commandName + "' does not accept arguments.");
        }
    }

    private void handleAdd(String argument) {
        checkArgumentIsPresent(argument, "add");
        undoManager.addCommand(argument);
        System.out.println("Command added: '" + argument + "'");
    }

    private void handleUndo(String argument) {
        checkArgumentIsNotPresent(argument, "undo");
        String removedCommand = undoManager.undoLastCommand();
        System.out.println("Undone command: '" + removedCommand + "'");
    }

    private void handleDelete(String argument) {
        checkArgumentIsPresent(argument, "delete");
        boolean commandRemoved = undoManager.checkAndDelete(argument);
        if (commandRemoved) {
            System.out.println("Command erased: '" + argument + "'");
        } else {
            System.out.println("Command '" + argument + "' not found in history.");
        }
    }

    private void handleHistory(String argument) {
        checkArgumentIsNotPresent(argument, "history");
        List<String> history = undoManager.seeListCommands();
        if (history.isEmpty()) {
            System.out.println("No commands in history.");
        } else {
            System.out.println("Command history:");
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ": " + history.get(i));
            }
            System.out.println("-----------------------------");
        }
    }

    private void handleClear(String argument) {
        checkArgumentIsNotPresent(argument, "clear");
        undoManager.clearHistory();
        System.out.println("Command history cleaned.");
    }

    private void handleHelp(String argument) {
        checkArgumentIsNotPresent(argument, "help");
        printHelp();
    }


    private void printHelp() {
        System.out.println("--- Available Commands ---");
        System.out.println("  add <text>   : Add a new command to the history.");
        System.out.println("  undo          : Undo the last added command.");
        System.out.println("  delete <text>: Removes a specific command from the history.");
        System.out.println("  history       : Show all command history.");
        System.out.println("  clear         : Clear all command history.");
        System.out.println("  help          : Show this help.");
        System.out.println("  exit          : Exit the console.");
        System.out.println("--------------------------");
    }
}

