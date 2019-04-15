package operators;

import exceptions.NotIntegerException;
import exceptions.SignException;
import helpers.Command;
import helpers.OperandStack;
import org.junit.*;

import java.math.BigDecimal;

public class FactorialTests {
    OperandStack stack;
    Command command;
    Factorial factorial;

    @Before
    public void setup() {
        this.stack = new OperandStack();
        this.command = new Command(0, "!");
        this.factorial = new Factorial();
    }

    @Test
    public void testFactorialWithoutException() {
        stack.push(new BigDecimal(1.0));
        factorial.execute(command, stack);
        Assert.assertEquals(new BigDecimal(1), stack.getLastOperand());


        stack.push(new BigDecimal(0.0));
        factorial.execute(command, stack);
        Assert.assertEquals(new BigDecimal(1), stack.getLastOperand());


        stack.push(new BigDecimal(4));
        factorial.execute(command, stack);
        Assert.assertEquals(BigDecimal.valueOf(24), stack.getLastOperand());
    }


    @Test(expected = SignException.class)
    public void testFactorialWithNegativeValue() {
        stack.push(new BigDecimal(-10));
        factorial.execute(command, stack);
    }

    @Test(expected = NotIntegerException.class)
    public void testFactorialWithDecimalValue() {
        stack.push(new BigDecimal(123.321));
        factorial.execute(command, stack);
    }
}
