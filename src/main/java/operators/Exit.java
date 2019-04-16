package operators;

import exceptions.ExitException;
import helpers.Command;
import helpers.OperandStack;

public class Exit extends Operator {
    static final String PATTERN = "^exit$";

    public Exit() {
        super(PATTERN, 1);
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        throw new ExitException(command);
    }
}
