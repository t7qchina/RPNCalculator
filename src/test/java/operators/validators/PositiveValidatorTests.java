package operators.validators;

import exceptions.SignException;
import helpers.Command;
import helpers.OperandStack;
import operators.Executable;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class PositiveValidatorTests {

    Command command;

    @Before
    public void setup() {
        command = new Command(0, "sqrt");
    }

    @Test
    public void testPositiveScenario() {
        Executable validator = new PositiveValidator();
        OperandStack stack = new OperandStack();
        stack.push(new BigDecimal(1.0));
        validator.execute(command, stack);
    }

    @Test(expected = SignException.class)
    public void testNegativeScenario() {
        Executable validator = new PositiveValidator();
        OperandStack stack = new OperandStack();
        stack.push(new BigDecimal(-1.0));
        validator.execute(command, stack);
    }
}
