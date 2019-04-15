package operators;

import helpers.Command;
import helpers.OperandStack;

public interface Executable {
    void execute(Command command, OperandStack stack);
}
