package operators;

import helpers.Command;
import helpers.OperandStack;
import org.junit.*;

import java.math.BigDecimal;

public class StackSnapshotTests {

    Command snapshot;
    Command undo;
    Command redo;
    Undo stackUndo;
    Redo stackRedo;
    StackSnapshot stackSnapshot;
    OperandStack stack;

    @Before
    public void setup() {
        undo = new Command(0, "undo");
        redo = new Command(0, "redo");
        snapshot = new Command(0, "snapshot");
        stackSnapshot = new StackSnapshot();
        stackUndo = new Undo();
        stackRedo = new Redo();

        stack = new OperandStack();
        stack.push(new BigDecimal("0.1"));
        stackSnapshot.execute(snapshot, stack);

        stack.push(new BigDecimal("0.2"));
        stackSnapshot.execute(snapshot, stack);

        stack.push(new BigDecimal("0.3"));
        stackSnapshot.execute(snapshot, stack);

        stack.push(new BigDecimal("0.4"));
        stackSnapshot.execute(snapshot, stack);

        stack.push(new BigDecimal("0.5"));
        stackSnapshot.execute(snapshot, stack);
    }

    @Test
    public void testStackSnapshot() {
        stackUndo.execute(undo, stack);
        stackUndo.execute(undo, stack);
        stackUndo.execute(undo, stack);

        stack.push(new BigDecimal("0.6"));
        stackSnapshot.execute(snapshot, stack);

        stackUndo.execute(undo, stack);
        stackRedo.execute(redo, stack);

        Assert.assertEquals(3, stack.size());
        Assert.assertEquals(new BigDecimal("0.1"), stack.get(0));
        Assert.assertEquals(new BigDecimal("0.2"), stack.get(1));
        Assert.assertEquals(new BigDecimal("0.6"), stack.get(2));
    }

    @Test
    public void testDuplicateSnapshot() {
        stackSnapshot.execute(snapshot, stack);
    }
}
