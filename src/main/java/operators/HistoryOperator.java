package operators;

import helpers.HistoryHandler;
import helpers.OperandStack;

public abstract class HistoryOperator extends Operator {

    private static final HistoryHandler HANDLER = new HistoryHandler();

    public HistoryOperator(String pattern, int priority) {
        super(pattern, priority);
    }

    public OperandStack forward() {
        return HANDLER.forward();
    }

    public OperandStack back() {
        return HANDLER.back();
    }

    public void addSnapshot(OperandStack stack) {
        HANDLER.addSnapshot(stack);
    }
}
