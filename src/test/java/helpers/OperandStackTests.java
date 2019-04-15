package helpers;

import org.junit.*;

import java.math.BigDecimal;

public class OperandStackTests {

    OperandStack stack;

    @Before
    public void setup() {
        stack = new OperandStack();
        stack.push(new BigDecimal(0));
        stack.push(new BigDecimal(1));
        stack.push(new BigDecimal(2));
    }

    @Test
    public void testToString() {
        Assert.assertEquals("0 1 2", stack.toString());
    }


    @Test
    public void testGetLastNBNumbers() {
        OperandStack result = stack.getLastNOperands(2);
        Assert.assertEquals(new BigDecimal(0), stack.get(0));
        Assert.assertEquals(new BigDecimal(1), stack.get(1));
        Assert.assertEquals(new BigDecimal(2), stack.get(2));
        Assert.assertEquals(3, stack.size());
        Assert.assertEquals(new BigDecimal(1), result.get(0));
        Assert.assertEquals(new BigDecimal(2), result.get(1));
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void testPopLastNBNumbers() {
        OperandStack result = stack.popLastNOperands(2);
        Assert.assertEquals(new BigDecimal(0), stack.get(0));
        Assert.assertEquals(1, stack.size());
        Assert.assertEquals(new BigDecimal(1), result.get(0));
        Assert.assertEquals(new BigDecimal(2), result.get(1));
        Assert.assertEquals(2, result.size());
    }


    @Test(expected = RuntimeException.class)
    public void testOvertaken() {
        stack.popLastNOperands(10);
    }
}
