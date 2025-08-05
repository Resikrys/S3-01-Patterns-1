package s3_01_singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UndoTest {

    private Undo undoInstance;

    @BeforeEach
    void setUp() {
        undoInstance = Undo.getInstance();
        undoInstance.clearHistory();
    }

    @Test
    void getCommandHistoryReturnsUnmodifiableList() {
        undoInstance.addCommand("add command1");
        undoInstance.addCommand("add command2");

        List<String> history = undoInstance.getCommandHistory();

        assertEquals(2, history.size());
        assertEquals("add command1", history.get(0));
        assertEquals("add command2", history.get(1));

        // Try to modify the list directly (Collections.unmodifiableList(commandHistory);)
        assertThrows(UnsupportedOperationException.class, () -> {
            history.add("add invalid command");
        });
    }

    @Test
    void getCommandHistoryReturnsCorrectOrderAndContent() {
        undoInstance.addCommand("CommandA");
        undoInstance.addCommand("CommandB");

        List<String> history = undoInstance.getCommandHistory();

        assertEquals(2, history.size());
        assertEquals("CommandA", history.get(0));
        assertEquals("CommandB", history.get(1));
    }
}