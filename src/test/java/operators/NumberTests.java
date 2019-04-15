package operators;

import exceptions.InvalidNumberFormatException;
import helpers.Command;
import helpers.OperandStack;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NumberTests {
    @Test
    public void testNumberWithoutException() {
        OperandStack stack = new OperandStack();
        Number number = new Number();
        number.execute(new Command(0, "1"), stack);
        Assert.assertEquals(new BigDecimal(1.0), stack.getLastNOperands(1)
                .get(0));

        number.execute(new Command(0, "1.1"), stack);
        Assert.assertEquals(new BigDecimal("1.1"), stack.getLastNOperands(1)
                .get(0));

        number.execute(new Command(0, "123.1e3"), stack);
        Assert.assertEquals(new BigDecimal("123100").toPlainString(), stack.getLastNOperands(1)
                .get(0)
                .toPlainString());
    }

    @Test
    public void testHighPrecisionNumber() {
        OperandStack stack = new OperandStack();
        String num = "0.0000000000000000000000001";
        Number number = new Number();
        number.execute(new Command(0, num), stack);
        Assert.assertEquals(BigDecimal.ZERO, stack.getLastNOperands(1)
                .get(0));
    }

    @Test(expected = InvalidNumberFormatException.class)
    public void testNumberWithException() {
        OperandStack stack = new OperandStack();
        new Number().execute(new Command(0, "e10"), stack);
    }
}
