package operators;

import helpers.Command;
import helpers.OperandStack;

import java.math.BigDecimal;

public class Redo extends HistoryOperator {
    static final String pattern = "^redo$";

    public Redo() {
        super(pattern);
        this.priority = 100;
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        stack.clear();
        OperandStack previous = super.forward();
        for (BigDecimal num : previous) {
            stack.push(num);
        }
    }
}
