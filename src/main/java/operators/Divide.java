package operators;

import helpers.Command;
import helpers.OperandStack;
import operators.validators.ParametersCountValidator;
import operators.validators.ZeroDividerValidator;

import java.math.BigDecimal;
import java.util.List;

public class Divide extends Operator {
    static final String PATTERN = "^\\/$";

    public Divide() {
        super(PATTERN, 100);
        this.validators.add(new ParametersCountValidator(2));
        this.validators.add(new ZeroDividerValidator());
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        List<BigDecimal> operands = stack.popLastNOperands(2);
        BigDecimal dividend = operands.get(0);
        BigDecimal divisor = operands.get(1);
        stack.push(dividend.divide(divisor, OperandStack.PRECISION));
    }
}
