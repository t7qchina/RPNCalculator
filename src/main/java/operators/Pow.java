package operators;

import helpers.Command;
import helpers.OperandStack;
import operators.validators.*;

import java.math.BigDecimal;
import java.util.List;

public class Pow extends Operator {
    static final String PATTERN = "^pow$";

    public Pow() {
        super(PATTERN, 100);
        this.validators.add(new ParametersCountValidator(2));
        this.validators.add(new IntegerValidator());
        this.validators.add(new ValueRangeValidator(new BigDecimal(-999999999), new BigDecimal(999999999)));
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        List<BigDecimal> operands = stack.popLastNOperands(2);
        stack.push(operands.get(0)
                .pow(operands.get(1)
                        .intValue(), OperandStack.PRECISION));
    }
}
