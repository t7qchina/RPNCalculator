package operators;

import exceptions.HistoryOutOfBoundaryException;
import helpers.Command;
import helpers.OperandStack;
import org.junit.*;

import java.math.BigDecimal;

public class UndoTests {

    private OperandStack stack;
    private Operator stackUndo;
    private Command undo;

    @Before
    public void setup() {
        undo = new Command(0, "undo");
        stackUndo = new Undo();
        stack = new OperandStack();

        Command snapshot = new Command(0, "snapshot");
        Operator stackSnapshot = new StackSnapshot();

        stack.push(BigDecimal.valueOf(0.1));
        stackSnapshot.execute(snapshot, stack);

        stack.push(BigDecimal.valueOf(0.2));
        stackSnapshot.execute(snapshot, stack);

        stack.push(BigDecimal.valueOf(0.3));
        stackSnapshot.execute(snapshot, stack);
    }

    @Test
    public void testUndo() {
        stackUndo.execute(undo, stack);

        Assert.assertEquals(2, stack.size());
        Assert.assertEquals(BigDecimal.valueOf(0.1), stack.getLastNOperands(2)
                .get(0));
        Assert.assertEquals(BigDecimal.valueOf(0.2), stack.getLastNOperands(2)
                .get(1));

        stackUndo.execute(undo, stack);

        Assert.assertEquals(1, stack.size());
        Assert.assertEquals(BigDecimal.valueOf(0.1), stack.getLastNOperands(1)
                .get(0));
    }

    @Test(expected = HistoryOutOfBoundaryException.class)
    public void testUndoOverflow() {
        for (int i = 0; i < 100; i++) {
            stackUndo.execute(undo, stack);
        }
    }
}
