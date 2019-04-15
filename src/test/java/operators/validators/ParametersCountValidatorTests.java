package operators.validators;

import exceptions.InsufficientParametersException;
import helpers.Command;
import helpers.OperandStack;
import operators.Executable;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ParametersCountValidatorTests {


    Command command;

    @Before
    public void setup() {
        command = new Command(0, "none");
    }

    @Test
    public void testZeroParameterScenario() {
        Executable validator = new ParametersCountValidator(0);
        validator.execute(command, new OperandStack());
    }

    @Test
    public void testMatchParameterCountScenario() {
        Executable validator = new ParametersCountValidator(1);
        OperandStack stack = new OperandStack();
        stack.push(new BigDecimal(1.0));
        validator.execute(command, stack);
    }

    @Test(expected = InsufficientParametersException.class)
    public void testLessParameterScenario() {
        Executable validator = new ParametersCountValidator(1);
        validator.execute(command, new OperandStack());
    }

    @Test
    public void testOverParameterScenario() {
        Executable validator = new ParametersCountValidator(1);
        OperandStack stack = new OperandStack();
        stack.push(new BigDecimal(1.0));
        stack.push(new BigDecimal(2.0));
        validator.execute(command, stack);
    }
}
