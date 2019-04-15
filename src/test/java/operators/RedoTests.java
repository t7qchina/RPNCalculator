package operators;

import helpers.Command;
import helpers.OperandStack;
import org.junit.*;

import java.math.BigDecimal;

public class RedoTests {

    Command redo;
    OperandStack stack;
    Operator stackRedo;

    @Before
    public void setup() {
        redo = new Command(0, "redo");
        stack = new OperandStack();
        stackRedo = new Redo();

        Command undo = new Command(0, "undo");
        Command snapshot = new Command(0, "snapshot");

        Operator stackUndo = new Undo();
        Operator stackSnapshot = new StackSnapshot();

        stack.push(new BigDecimal(0.1));
        stackSnapshot.execute(snapshot, stack);

        stack.push(new BigDecimal(0.2));
        stackSnapshot.execute(snapshot, stack);

        stack.push(new BigDecimal(0.3));
        stackSnapshot.execute(snapshot, stack);

        stackUndo.execute(undo, stack);
        stackUndo.execute(undo, stack);
    }

    @Test
    public void testRedo() {
        stackRedo.execute(redo, stack);

        Assert.assertEquals(2, stack.size());
        Assert.assertEquals(new BigDecimal("0.1"), stack.getLastNOperands(2)
                .get(0));
        Assert.assertEquals(new BigDecimal("0.2"), stack.getLastNOperands(2)
                .get(1));

        stackRedo.execute(redo, stack);

        Assert.assertEquals(3, stack.size());
        Assert.assertEquals(new BigDecimal("0.1"), stack.getLastNOperands(3)
                .get(0));
        Assert.assertEquals(new BigDecimal("0.2"), stack.getLastNOperands(3)
                .get(1));
        Assert.assertEquals(new BigDecimal("0.3"), stack.getLastNOperands(3)
                .get(2));
    }


    @Test
    public void testRedoOverflow() {
        for(int i = 0; i < 100; i++) {
            stackRedo.execute(redo, stack);
        }
    }
}
