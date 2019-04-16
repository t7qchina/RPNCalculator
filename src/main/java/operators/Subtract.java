package operators;

import helpers.Command;
import helpers.OperandStack;
import operators.validators.ParametersCountValidator;

import java.math.BigDecimal;
import java.util.List;

public class Subtract extends Operator {

    static final String PATTERN = "^\\-$";

    public Subtract() {
        super(PATTERN, 100);
        this.validators.add(new ParametersCountValidator(2));
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        List<BigDecimal> operands = stack.popLastNOperands(2);
        stack.push(operands.get(0)
                .subtract(operands.get(1), OperandStack.PRECISION));
    }
}
