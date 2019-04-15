package operators;

import helpers.Command;
import helpers.OperandStack;
import org.junit.*;

import java.math.BigDecimal;

public class SubtractTests {
    OperandStack stack;
    Command command;

    @Before
    public void setup() {
        this.stack = new OperandStack();
        this.command = new Command(0, "-");
    }

    @Test
    public void testSubtractWithoutException() {
        stack.push(new BigDecimal(1.0));
        stack.push(new BigDecimal(2.0));
        new Subtract().execute(command, stack);
        Assert.assertEquals(new BigDecimal(-1.0), stack.getLastOperand());

        stack.push(new BigDecimal(-5.0));
        new Subtract().execute(command, stack);
        Assert.assertEquals(new BigDecimal(4.0), stack.getLastOperand());
    }
}
