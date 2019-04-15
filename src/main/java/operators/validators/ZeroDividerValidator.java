package operators.validators;

import exceptions.ZeroDividerException;
import helpers.Command;
import helpers.OperandStack;
import operators.Executable;

import java.math.BigDecimal;
import java.util.List;

public class ZeroDividerValidator implements Executable {
    @Override
    public void execute(Command command, OperandStack stack) {
        List<BigDecimal> last = stack.getLastNOperands(1);
        if (last.get(0)
                .equals(BigDecimal.ZERO)) {
            throw new ZeroDividerException(command);
        }
    }
}
