package operators.validators;

import exceptions.ZeroDividerException;
import helpers.Command;
import helpers.OperandStack;
import operators.Executable;

import java.math.BigDecimal;

public class ZeroDividerValidator implements Executable {
    @Override
    public void execute(Command command, OperandStack stack) {
        BigDecimal last = stack.getLastOperand();
        if (last.equals(BigDecimal.ZERO)) {
            throw new ZeroDividerException(command);
        }
    }
}
