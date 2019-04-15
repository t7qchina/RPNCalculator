package helpers;

import org.junit.*;

import java.math.BigDecimal;

public class HistoryHandlerTests {

    HistoryHandler handler;
    OperandStack stack;

    @Before
    public void setup() {
        handler = new HistoryHandler();
        stack = new OperandStack();
        stack.push(new BigDecimal(1.0));
        stack.push(new BigDecimal(2.0));
        stack.push(new BigDecimal(3.0));
        stack.push(new BigDecimal(4.0));
        stack.push(new BigDecimal(5.0));
    }

    @Test
    public void testAddNewSnapshot() {
        handler.addSnapshot(stack);
        Assert.assertEquals(5, handler.getCurrent()
                .size());
    }

    @Test
    public void testBack() {
        handler.addSnapshot(stack);
        stack.pop();
        OperandStack copy = (OperandStack) stack.clone();
        handler.addSnapshot(stack);
        stack.pop();
        handler.addSnapshot(stack);
        OperandStack saved = handler.back();

        Assert.assertEquals(copy, saved);
    }

    @Test
    public void testOverBack() {
        handler.addSnapshot(stack);
        stack.pop();
        handler.addSnapshot(stack);
        stack.pop();
        handler.addSnapshot(stack);

        for(int i = 0; i < 10;i++) {
            handler.back();
        }

        Assert.assertEquals(new OperandStack(), handler.getCurrent());
    }

    @Test
    public void testForward() {
        handler.addSnapshot(stack);
        stack.pop();
        OperandStack copy = (OperandStack) stack.clone();
        handler.addSnapshot(stack);
        stack.pop();
        handler.addSnapshot(stack);
        handler.back();
        handler.back();
        OperandStack saved = handler.forward();

        Assert.assertEquals(copy, saved);
    }

    @Test
    public void testOverForward() {
        handler.addSnapshot(stack);
        stack.pop();
        handler.addSnapshot(stack);
        stack.pop();
        handler.addSnapshot(stack);

        for(int i = 0; i < 10;i++) {
            handler.forward();
        }
        Assert.assertEquals(stack, handler.getCurrent());
    }

}
