package operators;

import helpers.Command;
import helpers.OperandStack;
import operators.validators.ParametersCountValidator;
import operators.validators.ZeroDividerValidator;

import java.math.*;
import java.util.List;

public class Divide extends Operator {
    static final String pattern = "^\\/$";

    public Divide() {
        super(pattern);
        this.priority = 100;
        this.Validators.add(new ParametersCountValidator(2));
        this.Validators.add(new ZeroDividerValidator());
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        List<BigDecimal> operands = stack.popLastNOperands(2);
        BigDecimal dividend = operands.get(0);
        BigDecimal divisor = operands.get(1);
        stack.push(dividend
                .divide(divisor, new MathContext(OperandStack.PRECISION, RoundingMode.HALF_UP)));
    }
}
