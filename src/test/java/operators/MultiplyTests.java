package operators;

import helpers.Command;
import helpers.OperandStack;
import org.junit.*;

import java.math.BigDecimal;

public class MultiplyTests {

    OperandStack stack;
    Command multiply;

    @Before
    public void setup() {
        this.stack = new OperandStack();
        this.multiply = new Command(0, "/");
    }

    @Test
    public void testMultiplyWithoutException() {
        stack.push(new BigDecimal(1.0));
        stack.push(new BigDecimal(2.0));
        new Multiply().execute(multiply, stack);
        Assert.assertEquals(new BigDecimal(2), stack.getLastOperand());
    }
}
