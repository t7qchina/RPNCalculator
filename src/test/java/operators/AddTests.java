package operators;

import helpers.Command;
import helpers.OperandStack;
import org.junit.*;

import java.math.BigDecimal;

public class AddTests {
    OperandStack stack;
    Command add;

    @Before
    public void setup() {
        this.stack = new OperandStack();
        this.add = new Command(0, "+");
    }


    @Test
    public void testAddWithoutException() {
        stack.push(new BigDecimal(1.0));
        stack.push(new BigDecimal(2.0));
        new Add().execute(add, stack);
        Assert.assertEquals(new BigDecimal(3.0), stack.getLastNOperands(1)
                .get(0));
    }
}
