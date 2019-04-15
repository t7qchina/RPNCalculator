package operators.validators;

import exceptions.InsufficientParametersException;
import helpers.Command;
import helpers.OperandStack;
import operators.Executable;

public class ParametersCountValidator implements Executable {

    int count;

    public ParametersCountValidator(int count) {
        this.count = count;
    }

    @Override
    public void execute(Command command, OperandStack stack) {

        if (stack.size() < this.count) {
            throw new InsufficientParametersException(command);
        }
    }
}
