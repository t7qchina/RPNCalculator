package operators.validators;

import exceptions.ZeroDividerException;
import helpers.Command;
import helpers.OperandStack;
import operators.Executable;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ZeroDividerValidatorTests {

    Command command;

    @Before
    public void setup() {
        command = new Command(0, "/");
    }


    @Test(expected = ZeroDividerException.class)
    public void testZeroDividerScenario() {
        Executable validator = new ZeroDividerValidator();
        OperandStack stack = new OperandStack();
        stack.push(new BigDecimal(1.0));
        stack.push(new BigDecimal(0.0));
        validator.execute(command, stack);
    }

    @Test
    public void testNonZeroDividerScenario() {
        Executable validator = new ZeroDividerValidator();
        OperandStack stack = new OperandStack();
        stack.push(new BigDecimal(1.0));
        stack.push(new BigDecimal(1.0));
        validator.execute(command, stack);
    }
}
