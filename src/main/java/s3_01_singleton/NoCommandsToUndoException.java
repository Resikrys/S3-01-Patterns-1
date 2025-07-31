package s3_01_singleton;

public class NoCommandsToUndoException extends RuntimeException {
    public NoCommandsToUndoException(String message) {
        super(message);
    }
}
