package operators;

import helpers.Command;
import helpers.OperandStack;

import java.math.BigDecimal;

public class Undo extends HistoryOperator {
    static final String PATTERN = "^undo$";

    public Undo() {
        super(PATTERN, 100);
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        stack.clear();
        OperandStack previous = super.back();
        for (BigDecimal num : previous) {
            stack.push(num);
        }
    }
}
