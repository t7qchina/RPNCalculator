package operators;

import helpers.Command;
import helpers.OperandStack;

public class Clear extends Operator {
    static final String PATTERN = "^clear$";

    public Clear() {
        super(PATTERN, 100);
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        stack.clear();
    }
}
