package operators;

import helpers.Command;
import helpers.OperandStack;
import operators.validators.HistoryBoundaryChecker;

import java.math.BigDecimal;

public class Redo extends HistoryOperator {
    static final String PATTERN = "^redo$";

    public Redo() {
        super(PATTERN, 100);
        this.validators.add(new HistoryBoundaryChecker(HANDLER));
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        stack.clear();
        OperandStack previous = HANDLER.forward();
        for (BigDecimal num : previous) {
            stack.push(num);
        }
    }
}
