package s3_01_singleton;

import java.util.Scanner;

public class Manager {
    private Undo undoManager;
    private Scanner scanner;

    public Manager() {
        this.undoManager = Undo.getInstance();
        this.scanner = new Scanner(System.in);
        System.out.println("Command Console Started. Type 'help' to see the available commands.");
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
                System.err.println("Error: " + e.getMessage()); //Error message structure
            } catch (Exception e) {
                System.err.println("An unexpected error has occurred: " + e.getMessage());
            }
            System.out.println(); //</br>
        }
        scanner.close();
    }

    private void commandHandler(String command) throws InvalidCommandException {
        String trimmedCommand = command.trim();

        // Podrías usar un switch si tienes muchos comandos fijos, o if/else if para menos.
        if (trimmedCommand.startsWith("add ")) {
            String newCommand = trimmedCommand.substring(4).trim(); // Extract the text after "add "
            if (!newCommand.isEmpty()) {
                undoManager.addCommand(newCommand);
            } else {
                throw new InvalidCommandException("The 'add' command requires a text. Use: add <text>");
            }
        } else if (trimmedCommand.equalsIgnoreCase("undo")) {
            undoManager.undoLastCommand();
        } else if (trimmedCommand.startsWith("delete ")) {
            String commandToDelete = trimmedCommand.substring(7).trim(); // Extract the text after "delete "
            if (!commandToDelete.isEmpty()) {
                undoManager.checkAndDelete(commandToDelete);
            } else {
                throw new InvalidCommandException("Command 'delete' requires a text. Use: delete <text>");
            }
        } else if (trimmedCommand.equalsIgnoreCase("history")) {
            undoManager.seeListCommands();
        } else if (trimmedCommand.equalsIgnoreCase("clear")) {
            undoManager.clearHistory();
        } else if (trimmedCommand.equalsIgnoreCase("help")) {
            printHelp();
        } else {
            throw new InvalidCommandException("Invalid command: '" + command + "'. Type 'help' to see all available commands.");
        }
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

