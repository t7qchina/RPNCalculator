package operators;

import helpers.Command;
import helpers.OperandStack;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ClearTests {

    @Test
    public void testClear() {
        OperandStack stack = new OperandStack();
        stack.push(new BigDecimal(1.0));
        stack.push(new BigDecimal(2.0));
        new Clear().execute(new Command(0, "clear"), stack);
        Assert.assertEquals(0, stack.size());
    }
}
