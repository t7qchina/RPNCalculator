package operators;

import helpers.Command;
import helpers.OperandStack;
import operators.validators.ParametersCountValidator;

import java.math.*;
import java.util.List;

public class Add extends Operator {

    static final String pattern = "^\\+$";

    public Add() {
        super(pattern);
        this.priority = 100;
        this.Validators.add(new ParametersCountValidator(2));
    }

    @Override
    protected void internalExecute(Command command, OperandStack stack) {
        List<BigDecimal> operands = stack.popLastNOperands(2);
        stack.push(operands.get(0)
                .add(operands.get(1), new MathContext(OperandStack.PRECISION, RoundingMode.HALF_UP)));
    }
}
