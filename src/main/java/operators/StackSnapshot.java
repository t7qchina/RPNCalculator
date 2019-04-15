package operators;

import helpers.Command;
import helpers.OperandStack;

public class StackSnapshot extends HistoryOperator {

    static final String PATTERN = "^((?!redo|undo).)+$";

    public StackSnapshot() {
        super(PATTERN, 200);
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        HANDLER.addSnapshot(stack);
    }
}
