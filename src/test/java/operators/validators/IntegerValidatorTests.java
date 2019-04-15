package operators.validators;

import exceptions.NotIntegerException;
import helpers.Command;
import helpers.OperandStack;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class IntegerValidatorTests {
    OperandStack stack;
    IntegerValidator integerValidator;

    @Before
    public void setup() {
        this.stack = new OperandStack();
        this.integerValidator = new IntegerValidator();
    }

    @Test
    public void testInteger() {
        stack.push(new BigDecimal("10"));
        integerValidator.execute(new Command(0, "!"), stack);
    }

    @Test(expected = NotIntegerException.class)
    public void testNotInteger() {
        stack.push(new BigDecimal("12.34"));
        integerValidator.execute(new Command(0, "!"), stack);
    }
}
