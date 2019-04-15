package operators.validators;

import exceptions.SignException;
import helpers.Command;
import helpers.OperandStack;
import operators.Executable;

import java.math.BigDecimal;
import java.util.List;

public class PositiveValidator implements Executable {
    @Override
    public void execute(Command command, OperandStack stack) {
        List<BigDecimal> last = stack.getLastNOperands(1);
        if (last.get(0)
                .compareTo(new BigDecimal(0)) < 0) {
            throw new SignException(command, SignException.Sign.Negative);
        }
    }
}
