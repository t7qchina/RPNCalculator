package operators.validators;

import exceptions.NotIntegerException;
import helpers.Command;
import helpers.OperandStack;
import operators.Executable;

import java.math.BigDecimal;

public class IntegerValidator implements Executable {
    @Override
    public void execute(Command command, OperandStack stack) {
        BigDecimal n = stack.getLastOperand();
        if (n.stripTrailingZeros()
                .scale() > 0) {
            throw new NotIntegerException(command, n);
        }
    }
}
