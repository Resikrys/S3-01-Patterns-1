package s3_01_singleton;

public class Undo {
    private static Undo instance;

    private Undo() {
        System.out.println(" Undo instance created (only once!)");
    }

    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    // Class methods Undo (add, delete, history)
    public void addCommand(String command) {
        // Lógica para añadir comando
        System.out.println("Comando añadido: " + command);
    }
}
