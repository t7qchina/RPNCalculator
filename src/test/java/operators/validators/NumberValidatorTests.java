package operators.validators;

import exceptions.InvalidNumberFormatException;
import helpers.Command;
import helpers.OperandStack;
import operators.Executable;
import org.junit.Before;
import org.junit.Test;

public class NumberValidatorTests {
    OperandStack stack;

    @Before
    public void setup() {
        stack = new OperandStack();
    }

    @Test
    public void testPlainScenario() {
        Executable validator = new NumberValidator();
        validator.execute(new Command(0, "123.45"), stack);
    }

    @Test
    public void testScientificNotionScenario() {
        Executable validator = new NumberValidator();
        validator.execute(new Command(0, "1.2345e7"), stack);
        validator.execute(new Command(0, "1E7"), stack);
    }

    @Test(expected = InvalidNumberFormatException.class)
    public void testAlphabetScenario() {
        Executable validator = new NumberValidator();
        validator.execute(new Command(0, "E7"), stack);
    }
}
