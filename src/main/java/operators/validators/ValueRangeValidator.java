package operators.validators;

import exceptions.ValueRangeException;
import helpers.Command;
import helpers.OperandStack;
import operators.Executable;

import java.math.BigDecimal;

public class ValueRangeValidator implements Executable {

    BigDecimal min;
    BigDecimal max;

    public ValueRangeValidator(BigDecimal min, BigDecimal max) {
        super();
        this.max = max;
        this.min = min;
    }

    @Override
    public void execute(Command command, OperandStack stack) {
        BigDecimal last = stack.getLastOperand();
        if (last.compareTo(min) < 0 || last.compareTo(max) > 0) {
            throw new ValueRangeException(command, last, min, max);
        }
    }
}
