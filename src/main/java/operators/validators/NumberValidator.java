package operators.validators;

import exceptions.InvalidNumberFormatException;
import helpers.Command;
import helpers.OperandStack;
import operators.Executable;

public class NumberValidator implements Executable {
    @Override
    public void execute(Command command, OperandStack stack) {
        try {
            Double.parseDouble(command.getCommand());
        } catch (NumberFormatException ex) {
            throw new InvalidNumberFormatException(command);
        }
    }
}
