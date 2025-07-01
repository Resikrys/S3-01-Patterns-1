package s3_01_singleton;

import java.util.Scanner;

public class Manager {
    private Undo undoManager;
    private Scanner scanner;

    public Manager() {
        this.undoManager = Undo.getInstance();
        this.scanner = new Scanner(System.in);
    }
}
