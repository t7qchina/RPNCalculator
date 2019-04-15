package operators;

import helpers.Command;
import helpers.OperandStack;

public class Clear extends Operator {
    static final String pattern = "^clear$";

    public Clear() {
        super(pattern);
        this.priority = 100;
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        stack.clear();
    }
}
