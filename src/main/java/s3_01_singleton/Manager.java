package s3_01_singleton;

import java.util.HashMap;
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
        // Inicialitzem el mapa amb els comandaments i les seves accions
        this.commandHandlers = new HashMap<>();
        initializeCommands();
        System.out.println("Command Console Started. Type 'help' to see the available commands.");
    }

    // Mètode per inicialitzar el mapa de comandaments
    private void initializeCommands() {
        //Add handlers methods
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
            } catch (InvalidCommandException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (NoCommandsToUndoException e) {
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

        // Cerquem l'acció al mapa.
        Consumer<String> handler = commandHandlers.get(action);
        if (handler != null) {
            handler.accept(argument);
        } else {
            throw new InvalidCommandException("Invalid command: '" + action + "'. Type 'help' to see all available commands.");
        }
    }

    private void handleAdd(String argument) {
        if (argument.isEmpty()) {
            throw new InvalidCommandException("The 'add' command requires a text. Use: add <text>");
        }
        undoManager.addCommand(argument);
        System.out.println("Command added: '" + argument + "'");
    }

    private void handleUndo(String argument) {
        if (!argument.isEmpty()) {
            throw new InvalidCommandException("The 'undo' command does not accept arguments.");
        }
        String removedCommand = undoManager.undoLastCommand();
        System.out.println("Undone command: '" + removedCommand + "'");
    }

    private void handleDelete(String argument) {
        if (argument.isEmpty()) {
            throw new InvalidCommandException("Command 'delete' requires a text. Use: delete <text>");
        }
        boolean commandRemoved = undoManager.checkAndDelete(argument);
        if (commandRemoved) {
            System.out.println("Command erased: '" + argument + "'");
        } else {
            System.out.println("Command '" + argument + "' not found in history.");
        }
    }

    private void handleHistory(String argument) {
        if (!argument.isEmpty()) {
            throw new InvalidCommandException("The 'history' command does not accept arguments.");
        }
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
        if (!argument.isEmpty()) {
            throw new InvalidCommandException("The 'clear' command does not accept arguments.");
        }
        undoManager.clearHistory();
        System.out.println("Command history cleaned.");
    }

    private void handleHelp(String argument) {
        if (!argument.isEmpty()) {
            throw new InvalidCommandException("The 'help' command does not accept arguments.");
        }
        printHelp();
    }

//    private void commandHandler(String command) {
//        String trimmedCommand = command.trim();
//
//        if (trimmedCommand.startsWith("add ")) {
//            String newCommand = trimmedCommand.substring(4).trim(); // Extract the text after "add "
//            if (newCommand.isEmpty()) {
//                throw new InvalidCommandException("The 'add' command requires a text. Use: add <text>");
//            }
//
//            undoManager.addCommand(newCommand);
//            return;
//        }
//
//        if (trimmedCommand.equalsIgnoreCase("undo")) {
//            undoManager.undoLastCommand();
//            return;
//        }
//
//        if (trimmedCommand.startsWith("delete ")) {
//            String commandToDelete = trimmedCommand.substring(7).trim(); // Extract the text after "delete "
//            if (commandToDelete.isEmpty()) {
//                throw new InvalidCommandException("Command 'delete' requires a text. Use: delete <text>");
//            }
//            undoManager.checkAndDelete(commandToDelete);
//            return;
//
//        }
//
//        if (trimmedCommand.equalsIgnoreCase("history")) {
//            undoManager.seeListCommands();
//            return;
//        }
//
//        if (trimmedCommand.equalsIgnoreCase("clear")) {
//            undoManager.clearHistory();
//            return;
//        }
//
//        if (trimmedCommand.equalsIgnoreCase("help")) {
//            printHelp();
//            return;
//        }
//
//        throw new InvalidCommandException("Invalid command: '" + command + "'. Type 'help' to see all available commands.");
//
//    }

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

