package operators;

import helpers.Command;
import helpers.OperandStack;
import org.junit.*;

import java.math.BigDecimal;

public class RedoTests {

    private Command redo;
    private OperandStack stack;
    private Operator stackRedo;

    @Before
    public void setup() {
        redo = new Command(0, "redo");
        stack = new OperandStack();
        stackRedo = new Redo();

        Command undo = new Command(0, "undo");
        Command snapshot = new Command(0, "snapshot");

        Operator stackUndo = new Undo();
        Operator stackSnapshot = new StackSnapshot();

        stack.push(BigDecimal.valueOf(0.1));
        stackSnapshot.execute(snapshot, stack);

        stack.push(BigDecimal.valueOf(0.2));
        stackSnapshot.execute(snapshot, stack);

        stack.push(BigDecimal.valueOf(0.3));
        stackSnapshot.execute(snapshot, stack);

        stackUndo.execute(undo, stack);
        stackUndo.execute(undo, stack);
    }

    @Test
    public void testRedo() {
        stackRedo.execute(redo, stack);

        Assert.assertEquals(2, stack.size());
        Assert.assertEquals(BigDecimal.valueOf(0.1), stack.getLastNOperands(2)
                .get(0));
        Assert.assertEquals(BigDecimal.valueOf(0.2), stack.getLastNOperands(2)
                .get(1));

        stackRedo.execute(redo, stack);

        Assert.assertEquals(3, stack.size());
        Assert.assertEquals(BigDecimal.valueOf(0.1), stack.getLastNOperands(3)
                .get(0));
        Assert.assertEquals(BigDecimal.valueOf(0.2), stack.getLastNOperands(3)
                .get(1));
        Assert.assertEquals(BigDecimal.valueOf(0.3), stack.getLastNOperands(3)
                .get(2));
    }


    @Test
    public void testRedoOverflow() {
        for (int i = 0; i < 100; i++) {
            stackRedo.execute(redo, stack);
        }
    }
}
