package operators.validators;

import exceptions.SignException;
import helpers.Command;
import helpers.OperandStack;
import operators.Executable;

import java.math.BigDecimal;

public class PositiveValidator implements Executable {
    @Override
    public void execute(Command command, OperandStack stack) {
        BigDecimal last = stack.getLastOperand();
        if (last.compareTo(BigDecimal.ZERO) < 0) {
            throw new SignException(command, SignException.Sign.Negative);
        }
    }
}
