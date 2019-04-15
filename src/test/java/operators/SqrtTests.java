package operators;

import exceptions.SignException;
import helpers.Command;
import helpers.OperandStack;
import org.junit.*;

import java.math.BigDecimal;

public class SqrtTests {

    Command command;

    @Before
    public void setup() {
        command = new Command(0, "sqrt");
    }

    @Test
    public void testSqrtWithoutException() {
        Operator sqrt = new Sqrt();
        OperandStack stack = new OperandStack();
        stack.push(new BigDecimal(0.0));
        sqrt.execute(command, stack);
        Assert.assertEquals(new BigDecimal(0.0), stack.getLastOperand());

        stack.push(new BigDecimal(1.0));
        sqrt.execute(command, stack);
        Assert.assertEquals(new BigDecimal(1.0), stack.getLastOperand());

        stack.push(new BigDecimal("0.04"));
        sqrt.execute(command, stack);
        Assert.assertEquals(new BigDecimal("0.2"), stack.getLastOperand());

        stack.push(new BigDecimal(4.0));
        sqrt.execute(command, stack);
        Assert.assertEquals(new BigDecimal(2.0), stack.getLastOperand());

        stack.push(new BigDecimal(10.0));
        sqrt.execute(command, stack);
        Assert.assertEquals(new BigDecimal("3.16227766016838"), stack.getLastOperand());
    }

    @Test(expected = SignException.class)
    public void testSqrtWithException() {
        OperandStack stack = new OperandStack();
        stack.push(new BigDecimal(-1.0));
        new Sqrt().execute(command, stack);
    }
}
