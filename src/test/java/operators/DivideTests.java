package operators;

import exceptions.ZeroDividerException;
import helpers.Command;
import helpers.OperandStack;
import org.junit.*;

import java.math.BigDecimal;

public class DivideTests {

    OperandStack stack;
    Command divide;

    @Before
    public void setup() {
        this.stack = new OperandStack();
        this.divide = new Command(0, "/");
    }

    @Test
    public void testDivideWithoutException() {
        stack.push(new BigDecimal(1.0));
        stack.push(new BigDecimal(2.0));
        new Divide().execute(divide, stack);
        Assert.assertEquals(new BigDecimal(0.5), stack.getLastOperand());
    }

    @Test(expected = ZeroDividerException.class)
    public void testDivideWithException() {
        stack.push(new BigDecimal(100));
        stack.push(new BigDecimal(0));
        new Divide().execute(divide, stack);
    }
}
